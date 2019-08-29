package com.springframework.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Service
//@Primary
//@Profile("jp")
public class PrimaryJapaneseGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    public PrimaryJapaneseGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getJapaneseGreeting();
    }
}
