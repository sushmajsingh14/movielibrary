package com.librarymanagment.service;

import com.librarymanagment.dto.BookDTO;
import com.librarymanagment.entity.Book;
import com.librarymanagment.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public void createBook(BookDTO bookDTO){
        Book book = bookDTO.getBookEntity();

    }


}
