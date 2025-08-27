package com.example.jwtdemo.controller;

import com.example.jwtdemo.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Demo only: replace with real user service + password encoder
        if ("admin".equals(username) && "password".equals(password)) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "✅ You are authenticated!";
    }
}
