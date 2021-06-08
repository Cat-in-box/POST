package com.example.serverPOST.services;

import com.example.serverPOST.entities.Tag;
import com.example.serverPOST.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с тегами
 */
@Service
public class TagService {

    private final TagRepository tagRepository;

    /**
     * Instantiates a new Tag service
     *
     * @param tagRepository the tag repository
     */
    @Autowired
    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    /**
     * Создание нового тега
     *
     * @param tag - новая сущность Tag
     */
    public void create(Tag tag){
        tagRepository.save(tag);
    }

    /**
     * Получение списка всех тегов из БД
     *
     * @return list
     */
    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    /**
     * Получение тега по уникальному идентификатору
     *
     * @param id - id тега в БД
     * @return optional
     */
    public Optional<Tag> find(Long id){
        return tagRepository.findById(id);
    }

    /**
     * Обновление данных существующего тега
     *
     * @param id - id тега в БД
     * @param tag - обновленная сущность Tag для внесения в БД
     */
    public void update(Long id, Tag tag){
        tagRepository.deleteById(id);
        tagRepository.save(tag);
    }

    /**
     * Удаление существующего тега из БД
     *
     * @param id - id тега в БД
     */
    public void delete(Long id){
        tagRepository.deleteById(id);
    }

}