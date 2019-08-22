package com.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("en")
public class PrimaryGreetingService implements GreetingService {


    @Override
    public String sayGreeting() {
        return "Hello - I was injected by the primaryGreetingService";
    }
}
