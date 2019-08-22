package com.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello - I was injected by the constructor";
    }
}
