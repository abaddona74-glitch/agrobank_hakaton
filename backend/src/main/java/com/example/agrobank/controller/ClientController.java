package com.example.agrobank.controller;

import com.example.agrobank.model.Client;
import com.example.agrobank.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientController {
    private final ClientRepository repo;

    public ClientController(ClientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Client> list() {
        return repo.findAll();
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return repo.save(client);
    }
}
