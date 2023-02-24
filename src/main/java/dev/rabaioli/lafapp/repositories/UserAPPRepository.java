package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.UserAPP;

public interface UserAPPRepository extends JpaRepository<UserAPP, Integer> {

}
