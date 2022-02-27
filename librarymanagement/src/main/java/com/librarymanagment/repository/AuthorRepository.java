package com.librarymanagment.repository;

import com.librarymanagment.entity.Author;
import com.librarymanagment.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    public List<Author> findByLastName(String lastName);
}
