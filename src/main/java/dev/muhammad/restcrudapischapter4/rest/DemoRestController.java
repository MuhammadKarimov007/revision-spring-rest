package dev.muhammad.restcrudapischapter4.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@ResponseStatus(HttpStatus.OK)
public class DemoRestController {
    @GetMapping("hello")
    public String hello() {
        return "Hello, World";
    }
}
