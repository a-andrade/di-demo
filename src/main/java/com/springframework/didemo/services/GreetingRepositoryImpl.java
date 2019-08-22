package com.springframework.didemo.services;

import org.springframework.stereotype.Component;

@Component
public class GreetingRepositoryImpl implements GreetingRepository {

    @Override
    public String getEnglishGreeting() {
        return "Hello!";
    }

    @Override
    public String getSpanishGreeting() {
        return "Hola!";
    }

    @Override
    public String getJapaneseGreeting() {
        return "Konnichiwa!";
    }
}
