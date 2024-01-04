package com.reactor3.webflux.guide.controller;

import com.reactor3.webflux.guide.model.AsyncEventModel;
import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@Controller
@NoArgsConstructor
public class AsyncEventController {

  @GetMapping("/async-events")
  @ResponseBody
  public Flux<String> getAsyncEvents() {
    return Flux.range(1, 5)
        .delayElements(Duration.ofSeconds(1))
        .map(i -> "Event " + i);
  }
}