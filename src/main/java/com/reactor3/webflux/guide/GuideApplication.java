package com.reactor3.webflux.guide;

import com.reactor3.webflux.guide.configuration.ManualConfiguration;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Flux;

@SpringBootApplication
@Import(ManualConfiguration.class)
@Slf4j
public class GuideApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GuideApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> listNames = new ArrayList<>();
		listNames.addAll(List.of("Brayan", "Burgos"));

		Flux<String> names = Flux.fromIterable(listNames).doOnNext(name -> System.out.println(name));
				/*Flux.just("Brayan", "Daniel").doOnNext(e -> {
				if (e.isEmpty()){
						log.info("Element empty");
					}

		})
				.map(name -> {return name.toLowerCase();});*/


		//Subscription to observable
		names.subscribe(); //observatory or subscript
	}
}
