package com.example.serverPOST.repositories;

import com.example.serverPOST.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс JpaRepository для работы с коллекцией авторов
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}