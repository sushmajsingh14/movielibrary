package com.librarymanagment.controller;

import com.librarymanagment.dto.CategoryDTO;
import com.librarymanagment.service.CatgoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private CatgoryService catgoryService;

    @PostMapping("/categories")
    public void createCategory(@RequestBody CategoryDTO categroyDto){
        catgoryService.createService(categroyDto);
    }
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id){
        catgoryService.deleteCategory(id);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO> categories = catgoryService.getCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoriesDetail(@PathVariable int id){
        CategoryDTO category = catgoryService.getCategoriesDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }
    @GetMapping("/category/{name}")
    public List<CategoryDTO> categoryByName(@PathVariable String name){
        List<CategoryDTO> categoryDTO = catgoryService.getCategoryByName(name);
        return categoryDTO;
    }
}
