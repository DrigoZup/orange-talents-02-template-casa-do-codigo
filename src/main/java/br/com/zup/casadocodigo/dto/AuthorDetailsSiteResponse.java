package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Author;

public class AuthorDetailsSiteResponse {
    
    private String name;
    
    private String description;
    
    public AuthorDetailsSiteResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
}
