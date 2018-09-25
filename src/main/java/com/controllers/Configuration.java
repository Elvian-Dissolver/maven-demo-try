package com.controllers;

import com.models.StringProcessor;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

   @Bean
    StringProcessor stringProcessor() {return new StringProcessor();}
}
