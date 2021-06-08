package com.example.serverPOST.services;

import com.example.serverPOST.entities.Author;
import com.example.serverPOST.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с авторами
 */
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    /**
     * Instantiates a new Author service
     *
     * @param authorRepository the author repository
     */
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    /**
     * Создание нового типа вагона
     *
     * @param author - новая сущность Author
     */
    public void create(Author author){
        authorRepository.save(author);
    }

    /**
     * Получение списка всех авторов из БД
     *
     * @return list
     */
    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    /**
     * Получение автора по уникальному идентификатору
     *
     * @param id - id автора в БД
     * @return optional
     */
    public Optional<Author> find(Long id){
        return authorRepository.findById(id);
    }

    /**
     * Обновление данных существующего автора
     *
     * @param id - id автора в БД
     * @param author - обновленная сущность Author для внесения в БД
     */
    public void update(Long id, Author author){
        authorRepository.deleteById(id);
        authorRepository.save(author);
    }

    /**
     * Удаление существующего автора из БД
     *
     * @param id - id автора в БД
     */
    public void delete(Long id){
        authorRepository.deleteById(id);
    }

}


