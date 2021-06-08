package com.example.serverPOST.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность тега в БД
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "tag")
public class Tag {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "tag")
    private List<TagPost> tagPostList;
}
