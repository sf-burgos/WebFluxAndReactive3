package com.reactor3.webflux.guide.controller;

import com.reactor3.webflux.guide.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

  @GetMapping("/flux")
  public Flux<Message> getFluxMessages() {
    return Flux.just(
        new Message("Hello"),
        new Message("World"),
        new Message("Reactive")
    );
  }

  @GetMapping("/mono")
  public Mono<Message> getMonoMessage() {
    return Mono.just(new Message("Mono Message"));
  }
}