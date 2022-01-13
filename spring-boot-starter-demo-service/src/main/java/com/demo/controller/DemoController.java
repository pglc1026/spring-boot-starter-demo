package com.demo.controller;

import com.demo.result.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Will Liu
 * @date 2022/1/11
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/demoApi")
    public ResponseEntity<Result> demoApi(@RequestParam String message) {
        Result result = new Result();
        result.setMessage("server success: " + message);
        return ResponseEntity.ok(result);
    }
}
