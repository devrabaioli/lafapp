package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
