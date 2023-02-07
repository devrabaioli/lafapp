package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.Lost;

public interface LostRepository extends JpaRepository<Lost, Integer> {

}
