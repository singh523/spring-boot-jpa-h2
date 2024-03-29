package com.h2.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    System.out.println("Hello World!");
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/")
  public String home() {
    return "Spring Data JPA";
  }


}
