package com.librarymanagment.controller;

import com.librarymanagment.dto.AuthorDTO;
import com.librarymanagment.entity.Author;
import com.librarymanagment.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;
    @PostMapping("/Author")
    public void createAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.makeAuthor(authorDTO);

    }
    @DeleteMapping("/Author/{id}")
    public void removeAuthor(@PathVariable int id){
        authorService.removeAuthor(id);
    }
    @GetMapping("/Author")
    public void getAuthor(){
        authorService.getAuthor();
    }
    @GetMapping("/author/{id}")
    public void getAuthorById(@PathVariable int id){
        authorService.getAuthorById(id);
    }

    @GetMapping("/author/{LastName}")
     public void getAuthorByLastName(@PathVariable String lastName){
        authorService.getAuthorByLastName(lastName);
    }

}
