package com.manytomany.controller;

import com.manytomany.entity.BookEntity;
import com.manytomany.model.Book;
import com.manytomany.resposne.BookAuthorResponse;
import com.manytomany.service.BookAuthorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class BookAuthorController {

    @Autowired
    private final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @PostMapping(path = "/addbooks")
    private ResponseEntity<BookAuthorResponse> addBooks(@RequestBody Book book) {
        BookAuthorResponse bookAuthorResponse = bookAuthorService.addBooks(book);
        return new ResponseEntity<>(bookAuthorResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/books/{id}")
    private ResponseEntity<Book> getBooks(@PathVariable Long id) throws Exception {
        Book book = bookAuthorService.getBooks(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


}
