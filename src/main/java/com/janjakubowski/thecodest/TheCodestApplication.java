package com.janjakubowski.thecodest;

import com.janjakubowski.thecodest.service.CityImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TheCodestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCodestApplication.class, args);
	}

  @Autowired
  private CityImportService importService;

  @EventListener(ApplicationReadyEvent.class)
  public void autorun() {
    importService.importCities();
  }

}
