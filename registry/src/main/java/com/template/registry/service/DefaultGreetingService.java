package com.template.registry.service;

import org.springframework.stereotype.Service;
import com.template.registry.api.GreetingService;

@Service
public class DefaultGreetingService implements GreetingService {

    @Override
    public String greeting() {
        return "Hi!";
    }
}
