package com.reactor3.webflux.guide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/error-handling")
public class ErrorHandlingController {

  @GetMapping("/simulated-error")
  public Flux<String> getSimulatedError() {
    return Flux.just("Data1", "Data2", "Data3")
        .concatWith(Flux.error(new RuntimeException("Simulated Error")));
  }

  @GetMapping("/retry-example")
  public Flux<String> getRetryExample() {
    return Flux.just("Data1", "Data2", "Data3")
        .concatWith(Flux.error(new RuntimeException("Simulated Error")))
        .retry(3);  // Retry the flux up to 3 times
  }

  @GetMapping("/error-handling")
  public Mono<String> getErrorHandling() {
    return Mono.just("Data")
        .flatMap(data -> {
          // Simulate an error condition
          if (data.equals("Data")) {
            return Mono.error(new RuntimeException("Simulated Error"));
          }
          return Mono.just(data);
        })
        .onErrorResume(error -> Mono.just("FallbackResult"));
  }
}
