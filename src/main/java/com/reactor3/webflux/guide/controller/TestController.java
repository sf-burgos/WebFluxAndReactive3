package com.reactor3.webflux.guide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

  @GetMapping("/data")
  public Flux<String> fetchData() {
    return Flux.just("Data1", "Data2", "Data3");
  }

  @GetMapping("/transformed-flux")
  public Flux<String> getTransformedFlux() {
    return Flux.just("Element1", "Element2", "Element3")
        .map(element -> "Transformed_" + element)
        .filter(transformedElement -> transformedElement.startsWith("T"));
  }

  @GetMapping("/mono-example")
  public Mono<String> getMonoExample() {
    return Mono.just("SingleResult");
  }

  @GetMapping("/transformed-mono")
  public Mono<String> getTransformedMono() {
    return Mono.just("SingleResult")
        .map(result -> "Transformed_" + result)
        .flatMap(transformedResult -> Mono.just(transformedResult.toUpperCase()));
  }

  @GetMapping("/error-handling-mono")
  public Mono<Object> getErrorHandlingMono() {
    return Mono.error(new RuntimeException("Simulated error"))
        .onErrorResume(error -> Mono.just("FallbackResult"));
  }
}
