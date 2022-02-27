package com.librarymanagment.test.unit.controller;

import com.librarymanagment.controller.CategoryController;
import com.librarymanagment.dto.CategoryDTO;
import com.librarymanagment.service.CatgoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CatgoryService catgoryService;

    @Test
    public void getCategories_withSuccess() throws Exception {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        when(catgoryService.getCategories()).thenReturn(categoryDTOS);
        MockHttpServletResponse response =  mockMvc.perform(
                        MockMvcRequestBuilders.get("/categories")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    public void getCategoryDetail_withSuccess() throws Exception {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        CategoryDTO categoryDTO = new CategoryDTO("drama","drama",1);
        categoryDTOS.add(categoryDTO);
        String name="dramma";
        when(catgoryService.getCategoryByName(name)).thenReturn(categoryDTOS);
         mockMvc.perform(
                        MockMvcRequestBuilders.get("/category/"+name)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.[id]").value(1));
    }
}
