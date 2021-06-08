package com.example.serverPOST.repositories;

import com.example.serverPOST.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс JpaRepository для работы с коллекцией тегов
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
}
