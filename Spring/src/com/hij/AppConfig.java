package com.hij;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean
    public CStartEventHandler cStartEventHandler() {
        return new CStartEventHandler();
    }

    @Bean
    public CStopEventHandler cStopEventHandler() {
        return new CStopEventHandler();
    }

}