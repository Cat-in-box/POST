package com.example.serverPOST.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность лайка в БД
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "likes")
public class Likes {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author2;

    @ManyToOne
    @JoinColumn(name="text_post_id", nullable = false)
    private TextPost textPost;
}
