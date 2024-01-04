package com.reactor3.webflux.guide.model;


import ch.qos.logback.core.util.TimeUtil;
import java.time.Duration;
import java.util.concurrent.Executors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import java.util.concurrent.*;


public class AsyncEventModel {
  public Flux<String> createAsyncEventFlux() {
    return Flux.range(1, 5)
        .delayElements(Duration.ofSeconds(1))
        .map(i -> "Event " + i);
  }
}
