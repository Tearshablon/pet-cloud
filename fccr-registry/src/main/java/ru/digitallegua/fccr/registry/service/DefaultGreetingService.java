package ru.digitallegua.fccr.registry.service;

import org.springframework.stereotype.Service;
import ru.digitallegua.fccr.registry.api.GreetingService;

@Service
public class DefaultGreetingService implements GreetingService {

    @Override
    public String greeting() {
        return "Hi!";
    }
}
