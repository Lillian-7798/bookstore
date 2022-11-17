package com.example.function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.function.Function;

@SpringBootApplication
public class FunctionApplication {

    @Bean
    public Function<Flux<String>,Flux<BigDecimal>>price(){
        System.out.println("get price!");
        return flux->flux.map(value->new BigDecimal(value.split(",")[0]).multiply(new BigDecimal(value.split(",")[1])));
    }

    public static void main(String[] args) {
        SpringApplication.run(FunctionApplication.class, args);
    }

}
