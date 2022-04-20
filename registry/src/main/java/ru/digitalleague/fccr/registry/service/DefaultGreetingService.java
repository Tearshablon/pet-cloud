package ru.digitalleague.fccr.registry.service;

import org.springframework.stereotype.Service;
import ru.digitalleague.fccr.registry.api.GreetingService;

@Service
public class DefaultGreetingService implements GreetingService {

    @Override
    public String greeting() {
        return "Hi!";
    }
}
