package com.reactor3.webflux.guide.view;

import com.reactor3.webflux.guide.controller.AsyncEventController;

public class AsyncEventView {

  private final AsyncEventController asyncEventController;

  public AsyncEventView(AsyncEventController asyncEventController) {
    this.asyncEventController = asyncEventController;
  }

  public void displayAsyncEvents() {
    asyncEventController.getAsyncEvents().subscribe(
        event -> System.out.println("Received event: " + event),
        error -> System.err.println("Error: " + error),
        () -> System.out.println("Async events completed")
    );
  }
}