package com.example.agrobank.repository;

import com.example.agrobank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findByEmail(String email);
}
