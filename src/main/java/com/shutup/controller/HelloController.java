package com.shutup.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tom on 1/11/17.
 */
@RestController
@RequestMapping(path = {"/hello"})
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
        return "Hello "+name;
    }
}
