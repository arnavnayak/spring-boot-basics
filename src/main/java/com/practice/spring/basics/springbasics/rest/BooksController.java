package com.practice.spring.basics.springbasics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> books =  new ArrayList<>();
        books.add(new Book(123,"Murder in orient express","Agatha Christie"));
        books.add(new Book(124,"The Second Gong","Agatha Christie"));
        books.add(new Book(125,"Othello","William Shakespear"));
        return books;
    }
}
