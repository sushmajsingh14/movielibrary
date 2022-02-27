package com.librarymanagment.service;

import com.librarymanagment.dto.AuthorDTO;
import com.librarymanagment.entity.Author;
import com.librarymanagment.exception.NotFoundException;
import com.librarymanagment.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@AllArgsConstructor
@Data
public class AuthorService {
    private final AuthorRepository authorRepository;

    public void makeAuthor(AuthorDTO authorDTO){
        Author author = new Author();
        author.setLastName(authorDTO.getLastName());
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFirstName());
    }
    public void removeAuthor(int id){authorRepository.delete(authorRepository.getById(id));}

    public List<AuthorDTO> getAuthor(){
        List<Author> author =new ArrayList<>();
        author = authorRepository.findAll();
        return getAuthorDTO(author);
    }


    private List<AuthorDTO> getAuthorDTO(List<Author> authors) {
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authors.forEach(x->{
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setFirstName(x.getFirstName());
            authorDTO.setId(x.getId());
            authorDTO.setLastName(x.getLastName());
            authorDTOS.add(authorDTO);
        });
        return authorDTOS;
    }
    public AuthorDTO getAuthorById(int id){
        Author author = authorRepository.findById(id).orElseThrow(()-> new NotFoundException("Author with id"+id+"not found"));
        return new AuthorDTO(author.getFirstName(),author.getLastName(), author.getId());
    }
    public List<AuthorDTO> getAuthorByLastName(String lastName){
        List<Author> author = authorRepository.findByLastName(lastName);
        return getAuthorDTO(author);
    }

}
