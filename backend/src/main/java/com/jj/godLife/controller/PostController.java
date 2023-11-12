package com.jj.godLife.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @GetMapping
    public ResponseEntity<String> get()
    {
        return ResponseEntity.ok("ok");
    }
}
