package com.example.agrobank.config;

import com.example.agrobank.model.Client;
import com.example.agrobank.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner init(ClientRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Client("Alice", "alice@example.com", encoder.encode("password123")));
                repo.save(new Client("Bob", "bob@example.com", encoder.encode("password123")));
            }
        };
    }
}
