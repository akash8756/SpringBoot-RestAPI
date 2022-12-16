package com.manytomanyRestTemplate.controller;

import com.manytomanyRestTemplate.model.Book;
import com.manytomanyRestTemplate.service.RestTemplateBookAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAuthorController {
    private final RestTemplateBookAuthorService restTemplateBookAuthorService;

    public BookAuthorController(RestTemplateBookAuthorService restTemplateBookAuthorService) {
        this.restTemplateBookAuthorService = restTemplateBookAuthorService;
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable Long id){
        Book book=restTemplateBookAuthorService.getBooks(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
