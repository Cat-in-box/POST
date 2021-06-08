package com.example.serverPOST.services;

import com.example.serverPOST.entities.TagPost;
import com.example.serverPOST.entities.TextPost;
import com.example.serverPOST.repositories.TextPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с записями (постами)
 */
@Service
public class TextPostService {

    private final TextPostRepository textPostRepository;

    /**
     * Instantiates a new TextPost service
     *
     * @param textPostRepository the text post repository
     */
    @Autowired
    public TextPostService(TextPostRepository textPostRepository){
        this.textPostRepository = textPostRepository;
    }

    /**
     * Создание новой записи (поста)
     *
     * @param textPost - новая сущность Ticket
     */
    public void create(TextPost textPost){
        textPostRepository.save(textPost);
    }

    /**
     * Получение списка всех записей (постов) из БД
     *
     * @return list
     */
    public List<TextPost> findAll(){
        return textPostRepository.findAll();
    }

    /**
     * Получение записи (поста) по уникальному идентификатору
     *
     * @param id - id записи (поста) в БД
     * @return optional
     */
    public Optional<TextPost> find(Long id){
        return textPostRepository.findById(id);
    }

    /**
     * Обновление данных существующей записи (поста)
     *
     * @param id - id записи (поста) в БД
     * @param textPost - обновленная сущность TextPost для внесения в БД
     */
    public void update(Long id, TextPost textPost){
        textPostRepository.deleteById(id);
        textPostRepository.save(textPost);
    }

    /**
     * Удаление существующей записи (поста) из БД
     *
     * @param id - id записи (поста) в БД
     */
    public void delete(Long id){
        textPostRepository.deleteById(id);
    }

}