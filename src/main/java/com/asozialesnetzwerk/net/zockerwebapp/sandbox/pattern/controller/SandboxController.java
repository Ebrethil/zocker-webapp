package com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.controller;

import com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.composite.Client;
import com.asozialesnetzwerk.net.zockerwebapp.sandbox.pattern.composite.ParentElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SandboxController {

    private final Client client;

    @Autowired
    public SandboxController(Client client) {
        this.client = client;
    }

    @GetMapping("api/sandbox/composite")
    public HttpEntity<ParentElement> getTree() {
        ParentElement root = client.setUp();

        return new ResponseEntity<>(root, HttpStatus.OK);
    }
}
