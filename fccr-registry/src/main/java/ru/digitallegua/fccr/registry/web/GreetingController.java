package ru.digitallegua.fccr.registry.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.digitallegua.fccr.registry.api.GreetingService;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/hi")
    public String greeting() {
        return greetingService.greeting();
    }
}
