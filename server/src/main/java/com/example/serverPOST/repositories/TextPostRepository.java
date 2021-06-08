package com.example.serverPOST.repositories;

import com.example.serverPOST.entities.TextPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс JpaRepository для работы с коллекцией записей (постов)
 */
public interface TextPostRepository extends JpaRepository<TextPost, Long> {
}