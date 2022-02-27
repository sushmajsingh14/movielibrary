package com.librarymanagment.service;

import com.librarymanagment.dto.CategoryDTO;
import com.librarymanagment.entity.Category;
import com.librarymanagment.exception.NotFoundException;
import com.librarymanagment.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@AllArgsConstructor
@Data
public class CatgoryService {

    private final CategoryRepository categoryRepository;
    public void createService(CategoryDTO categroyDto){
        Category category = categroyDto.getCategoryEntity();
        categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.delete(categoryRepository.getById(id));
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories =  categoryRepository.findAll();
        List<CategoryDTO> categroyDtos = getCategoriesDTO(categories);
        return categroyDtos;
    }

    public CategoryDTO getCategoriesDetail(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category with id not found"+id));
        return  new CategoryDTO(category.getName(),category.getDescription(),category.getId());
    }
    public List<CategoryDTO> getCategoryByName(String s){
        List<Category> categories = categoryRepository.findByName(s);
        List<CategoryDTO> categoryDTOS = getCategoriesDTO(categories);
        return categoryDTOS;
    }

    private List<CategoryDTO> getCategoriesDTO(List<Category> categories) {
        List<CategoryDTO> categroyDtos = new ArrayList<>();
        categories.forEach(x->{
            CategoryDTO categroyDto = new CategoryDTO();
            categroyDto.setName(x.getName());
            categroyDto.setDescription(x.getDescription());
            categroyDto.setId(x.getId());
            categroyDtos.add(categroyDto);
        });
        return categroyDtos;
    }

}

