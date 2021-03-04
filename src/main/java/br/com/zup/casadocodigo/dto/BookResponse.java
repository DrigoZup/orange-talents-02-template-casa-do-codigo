package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Book;

public class BookResponse {
    
    private Long id;

    private String title;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
