package com.librarymanagment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
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
    @JoinTable(name = "bookauthor",
            joinColumns = @JoinColumn(name = "bookid", referencedColumnName = "id"))
    @ManyToMany
    private Set<Author> authors;

    @JoinTable(name = "bookcategory",
            joinColumns = @JoinColumn(name = "bookid", referencedColumnName = "id"))
    @ManyToMany
    private Set<Category> categories;
}
