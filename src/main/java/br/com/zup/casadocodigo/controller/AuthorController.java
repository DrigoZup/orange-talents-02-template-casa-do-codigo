package br.com.zup.casadocodigo.controller;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.casadocodigo.dto.AuthorResponse;
import br.com.zup.casadocodigo.form.CreateAuthorForm;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.repository.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    
    @Autowired
    AuthorRepository authorRepository;
    
    @PostMapping
    @Transactional
    public ResponseEntity<AuthorResponse> singInAuthor(@RequestBody @Valid CreateAuthorForm form, UriComponentsBuilder uriBuilder) {
        Author author = form.converter();
        authorRepository.save(author);
        
        URI uri = uriBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri();
        return ResponseEntity.created(uri).body(new AuthorResponse(author));
    }
    

}
