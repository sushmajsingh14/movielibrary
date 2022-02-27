package com.librarymanagment.dto;

import com.librarymanagment.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private String firstName;
    private String lastName;
    private int id;
    public Author getAuthor(){
        Author author = new Author();
        author.setFirstName(this.getFirstName());
        author.setLastName(this.getLastName());
        return author;
    }
}
