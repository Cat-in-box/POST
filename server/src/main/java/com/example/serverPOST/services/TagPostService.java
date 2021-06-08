package com.example.serverPOST.services;

import com.example.serverPOST.entities.TagPost;
import com.example.serverPOST.repositories.TagPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с зависимостями между тегами и постами
 */
@Service
public class TagPostService {

    private final TagPostRepository tagPostRepository;

    /**
     * Instantiates a new TagPost service
     *
     * @param tagPostRepository the tag post repository
     */
    @Autowired
    public TagPostService(TagPostRepository tagPostRepository){
        this.tagPostRepository = tagPostRepository;
    }

    /**
     * Создание новой зависимости между тегами и постами
     *
     * @param tagPost - новая сущность TagPost
     */
    public void create(TagPost tagPost){
        tagPostRepository.save(tagPost);
    }

    /**
     * Получение списка всех зависимостей между тегами и постами из БД
     *
     * @return list
     */
    public List<TagPost> findAll(){
        return tagPostRepository.findAll();
    }

    /**
     * Получение зависимости между тегами и постами по уникальному идентификатору
     *
     * @param id - id зависимости между тегами и постами в БД
     * @return optional
     */
    public Optional<TagPost> find(Long id){
        return tagPostRepository.findById(id);
    }

    /**
     * Обновление данных существующей зависимости между тегами и постами
     *
     * @param id - id зависимости между тегами и постами в БД
     * @param tagPost - обновленная сущность TagPost для внесения в БД
     */
    public void update(Long id, TagPost tagPost){
        tagPostRepository.deleteById(id);
        tagPostRepository.save(tagPost);
    }

    /**
     * Удаление существующей зависимости между тегами и постами из БД
     *
     * @param id - id зависимости между тегами и постами в БД
     */
    public void delete(Long id){
        tagPostRepository.deleteById(id);
    }

}