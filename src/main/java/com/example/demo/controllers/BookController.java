package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping(path = "/add")
    public String addBook(@RequestParam String title, @RequestParam String author){
        Book b = new Book();
        b.setAuthor(author);
        b.setTitle(title);
        bookRepo.save(b);
        return "Book was saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Book> addBook(){
        return  bookRepo.findAll();
    }


}
