package com.librarymanagment.controller;

import com.librarymanagment.dto.BookDTO;
import com.librarymanagment.repository.BookRepository;
import com.librarymanagment.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;


@PostMapping("/books")
public void createBook(@RequestBody BookDTO bookRequestDTO){

    }
}
