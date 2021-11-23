package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan("org.example")
public class RootConfiguration {

    @Bean
    public Scanner Scanner() {
        return new Scanner(System.in);
    }

    @Bean
    List<?> operationsList() {
        return new LinkedList<>();
    }

    @Bean
    List<?> usersList() {
        return new ArrayList<>();
    }
}