package com.reactor3.webflux.guide.configuration;

import com.reactor3.webflux.guide.controller.AsyncEventController;
import com.reactor3.webflux.guide.model.AsyncEventModel;
import com.reactor3.webflux.guide.view.AsyncEventView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualConfiguration {

  @Bean
  public AsyncEventModel asyncEventModel() {
    return new AsyncEventModel();
  }

  @Bean
  public AsyncEventController asyncEventController() {
    return new AsyncEventController();
  }

  @Bean
  public AsyncEventView asyncEventView(AsyncEventController asyncEventController) {
    return new AsyncEventView(asyncEventController);
  }
}