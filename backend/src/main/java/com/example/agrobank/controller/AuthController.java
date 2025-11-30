package com.example.agrobank.controller;

import com.example.agrobank.model.Client;
import com.example.agrobank.repository.ClientRepository;
import com.example.agrobank.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final ClientRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(ClientRepository repo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");
        String password = body.get("password");
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "email and password required"));
        }
        if (repo.findByEmail(email).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "email already registered"));
        }
        String encoded = passwordEncoder.encode(password);
        Client client = new Client(name, email, encoded);
        repo.save(client);
        return ResponseEntity.ok(Map.of("message", "registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "email and password required"));
        }
        var opt = repo.findByEmail(email);
        if (opt.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("error", "invalid credentials"));
        }
        Client client = opt.get();
        if (!passwordEncoder.matches(password, client.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "invalid credentials"));
        }
        String token = jwtUtil.generateToken(client.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
