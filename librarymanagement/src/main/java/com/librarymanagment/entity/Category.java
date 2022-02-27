package com.librarymanagment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "category")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private int id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "categories")
    private Set<Book> books;
}