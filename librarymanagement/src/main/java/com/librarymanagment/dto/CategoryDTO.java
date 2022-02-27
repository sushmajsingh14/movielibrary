package com.librarymanagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanagment.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String name;
    private String description;
    private int id;

    @JsonIgnore
    public Category getCategoryEntity() {
        Category category = new Category();
        category.setName(this.getName());
        category.setDescription(this.getDescription());
        return category;
    }
}
