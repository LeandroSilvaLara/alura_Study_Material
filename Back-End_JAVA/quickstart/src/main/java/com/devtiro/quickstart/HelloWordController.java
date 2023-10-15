package com.devtiro.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping(path ="/hello")
    public String helloWord() {
        return "Hello word!";
    }
}
