package com.manytomanyRestTemplate.service;

import com.manytomanyRestTemplate.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateBookAuthorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    public Book getBooks(Long id) {
        Book book= (Book) restTemplate.getForObject(url+"/books/{id}", Book.class, id);
        return book;
    }
}
