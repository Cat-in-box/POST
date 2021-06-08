package com.example.serverPOST.services;

import com.example.serverPOST.entities.Likes;
import com.example.serverPOST.repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с лайками
 */
@Service
public class LikesService {

    private final LikesRepository likesRepository;

    /**
     * Instantiates a new Likes service
     *
     * @param likesRepository the likes repository
     */
    @Autowired
    public LikesService(LikesRepository likesRepository){
        this.likesRepository = likesRepository;
    }

    /**
     * Создание нового лайка
     *
     * @param likes - новая сущность Likes
     */
    public void create(Likes likes){
        likesRepository.save(likes);
    }

    /**
     * Получение списка всех лайков из БД
     *
     * @return list
     */
    public List<Likes> findAll(){
        return likesRepository.findAll();
    }

    /**
     * Получение лайка по уникальному идентификатору
     *
     * @param id - id лайка в БД
     * @return optional
     */
    public Optional<Likes> find(Long id){
        return likesRepository.findById(id);
    }

    /**
     * Обновление данных существующего лайка
     *
     * @param id - id лайка в БД
     * @param likes - обновленная сущность Likes для внесения в БД
     */
    public void update(Long id, Likes likes){
        likesRepository.save(likes);
    }

    /**
     * Удаление существующего лайка из БД
     *
     * @param id - id лайка в БД
     */
    public void delete(Long id){
        likesRepository.deleteById(id);
    }

}


