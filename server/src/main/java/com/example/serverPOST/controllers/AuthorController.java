package com.example.serverPOST.controllers;

import com.example.serverPOST.entities.Author;
import com.example.serverPOST.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;


/**
 * The type Author controller
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService AuthorService;

    /**
     * Instantiates a new Client controller.
     *
     * @param AuthorService the client service
     */
    @Autowired
    public AuthorController(AuthorService AuthorService) {
        this.AuthorService = AuthorService;
    }

    /**
     * Авторизация клиента
     *
     * @param login - логин клиента
     * @param password - пароль клиента
     * @return response entity
     */
    @GetMapping("/authorisation/{login}/{password}")
    public ResponseEntity<String> authorisation(@PathVariable(name = "login") String login, @PathVariable(name = "password") String password) {
        final List<Author> clientList = AuthorService.findAll();
        // Ищем клиента по переданному логину
        for (Author author : clientList) {
            // Если нашли, проверяем переданный пароль
            if (author.getLogin().equals(login)) {
                // Пароль совпал - возвращаем id клиента для cookie
                if (author.getPassword().equals(password)) {
                    return new ResponseEntity<>(author.getId().toString(), HttpStatus.OK);
                    // Клиент допустил ошибку в пароле
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
        }

        //Если не нашли такого клиента
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Создание нового клиента
     *
     * @param authorInfo - словарь информации о клиенте
     * @return response entity
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HashMap<String, String> authorInfo) {
        // Проверка на уникальность login'а в БД
        for (Author existAuthor : AuthorService.findAll()) {
            if (existAuthor.getLogin().equals(authorInfo.get("login"))){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }

        Author author = new Author();
        // Генерация нового id
        /*
        for (Integer i = 1; i < ClientService.findAll().size()+1; i++) {
            if (ClientService.find(Long.parseLong(i.toString())).isEmpty()) {
                client.setId(Long.parseLong(i.toString()));
            }
        }
        if (client.getId() == null) {
            client.setId(Long.parseLong(Integer.toString(ClientService.findAll().size()+1)));
        }*/

        System.out.print("THREE");
        // Заносим новые значения в сущность клиента
        author.setLogin(authorInfo.get("login"));
        if (authorInfo.get("password").length()>=8) {
            author.setPassword(authorInfo.get("password"));
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (authorInfo.get("nickname") != "") {
            author.setNickname(authorInfo.get("nickname"));
        }

        // Создаем клиента в БД
        AuthorService.create(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}