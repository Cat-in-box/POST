package com.example.serverPOST.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность поста в БД
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "text_post")
public class TextPost {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "post_type")
    private Boolean postType;


    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author1;

    @OneToMany(mappedBy = "textPost")
    private List<Likes> likesList;

    @OneToMany(mappedBy = "textPost")
    private List<TagPost> tagPostList;


    @ManyToOne
    @JoinColumn(name="head_post", nullable = false)
    private TextPost headTextPost;

    @OneToMany(mappedBy = "headTextPost")
    private List<TextPost> commTextPost;
}
