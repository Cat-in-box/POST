package com.example.serverPOST.repositories;

import com.example.serverPOST.entities.TagPost;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс JpaRepository для работы с коллекцией соотношений тегов и постов
 */
public interface TagPostRepository extends JpaRepository<TagPost, Long> {
}