package com.example.serverPOST.repositories;

import com.example.serverPOST.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс JpaRepository для работы с коллекцией лайков
 */
public interface LikesRepository extends JpaRepository<Likes, Long> {
}