package com.reactor3.webflux.guide.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxContextController {

  // Combine two Flux using the zip operator
  @GetMapping("/combine-flux")
  public Flux<String> combineFlux() {
    Flux<String> flux1 = Flux.just("Data1", "Data2", "Data3");
    Flux<String> flux2 = Flux.just("InfoA", "InfoB", "InfoC");

    // Use the zip operator to combine elements pairwise
    return Flux.zip(flux1, flux2, (data, info) -> data + " - " + info);
  }

  // Merge two Flux into a single Flux
  @GetMapping("/merge-flux")
  public Flux<String> mergeFlux() {
    Flux<String> flux1 = Flux.just("Data1", "Data2", "Data3");
    Flux<String> flux2 = Flux.just("InfoA", "InfoB", "InfoC");

    // Use the merge operator to combine elements into a single Flux
    return Flux.merge(flux1, flux2);
  }

  // Concatenate two Flux maintaining order
  @GetMapping("/concat-flux")
  public Flux<String> concatFlux() {
    Flux<String> flux1 = Flux.just("Data1", "Data2", "Data3");
    Flux<String> flux2 = Flux.just("InfoA", "InfoB", "InfoC");

    // Use the concat operator to combine elements in order
    return Flux.concat(flux1, flux2);
  }

  // Combine two Mono using the zip operator
  @GetMapping("/combine-mono")
  public Mono<String> combineMono() {
    Mono<String> mono1 = Mono.just("SingleData");
    Mono<String> mono2 = Mono.just("SingleInfo");

    // Use the zip operator to combine elements pairwise
    return Mono.zip(mono1, mono2, (data, info) -> data + " - " + info);
  }


}
