package br.com.zup.casadocodigo.dto;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import br.com.zup.casadocodigo.model.Author;

public class AuthorResponse {

    private Long id;
    
    private String name;

    private String description;

    private String email;

    // private String password;

    private LocalDateTime singInMoment = LocalDateTime.now();

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.description = author.getDescription();
        this.email = author.getEmail();
        this.singInMoment = author.getSingInMoment();
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getSingInMoment() {
        return singInMoment;
    }
    
    public static Page<AuthorResponse> converter(Page<Author> authors) {
        return authors.map(AuthorResponse::new);
    }
}
