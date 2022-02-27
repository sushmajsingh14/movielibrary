package com.librarymanagment.dto;

import com.librarymanagment.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int id;
    private String name;
    private String description;
    private int pages;
    private double price;
    private String publication;
    private Date dateOfRelease;
    private String genre;
    private String isbn;
    private String image;
    private Set<AuthorDTO> authors;
    private Set<String> categories;

    public Book getBookEntity() {
        Book book = new Book();
        return book;
    }
}
