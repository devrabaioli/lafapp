package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
