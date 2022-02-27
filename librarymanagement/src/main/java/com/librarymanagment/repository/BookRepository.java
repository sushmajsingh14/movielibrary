package com.librarymanagment.repository;

import com.librarymanagment.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
