package com.librarymanagment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

}
