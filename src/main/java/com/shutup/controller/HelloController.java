package com.shutup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Created by Tom on 1/11/17.
 */
@RestController
@RequestMapping(path = {"/hello"})
public class HelloController implements com.shutup.common.Constants{
    @RolesAllowed({Role_Administrator})
    @RequestMapping(path = {"/admin"},method = RequestMethod.GET)
    public String sayHelloAdmin(@RequestParam String name) {
        return "Hello "+name;
    }

    @RolesAllowed({Role_Administrator,Role_Club_Owner})
    @RequestMapping(path = {"/owner"},method = RequestMethod.GET)
    public String sayHelloOwner(@RequestParam String name) {
        return "Hello "+name;
    }
}
