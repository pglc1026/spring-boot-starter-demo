package com.demo.client.controller;

import com.demo.starter.api.DemoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Will Liu
 * @date 2022/1/11
 */
@RestController
@RequestMapping("/demo/client")
public class ClientController {

    @Autowired
    private DemoApi demoApi;

    @GetMapping("/clientApi")
    public ResponseEntity<String> clientApi(@RequestParam String message) {
        return ResponseEntity.ok(demoApi.demoAPi(message).getMessage());
    }

}
