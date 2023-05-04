package com.interview.demo.controller;

import com.interview.demo.config.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    @Autowired
    JwtService jwtService;

    @GetMapping
    public ResponseEntity<String> sayHello(HttpServletRequest request) {
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ",""); ;
        final String username = jwtService.extractUsername(token);
        return ResponseEntity.ok("Hello "+ username);
    }


}
