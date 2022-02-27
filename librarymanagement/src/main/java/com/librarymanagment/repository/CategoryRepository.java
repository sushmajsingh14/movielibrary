package com.librarymanagment.repository;

import com.librarymanagment.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    public List<Category> findByName(String name);
}
