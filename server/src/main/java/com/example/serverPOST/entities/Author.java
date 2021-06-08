package com.example.serverPOST.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность автора в БД
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;


    @OneToMany(mappedBy = "author1")
    private List<TextPost> textPostList;

    @OneToMany(mappedBy = "author2")
    private List<Likes> likesList;
}
