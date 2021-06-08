package com.example.serverPOST.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность сопоставления тегов с постами в БД
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tag_post")
public class TagPost {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="text_post_id", nullable = false)
    private TextPost textPost;

    @ManyToOne
    @JoinColumn(name="tag_id", nullable = false)
    private Tag tag;
}
