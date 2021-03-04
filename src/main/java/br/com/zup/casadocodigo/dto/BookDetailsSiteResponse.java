package br.com.zup.casadocodigo.dto;

import java.time.LocalDate;
import br.com.zup.casadocodigo.model.Book;

public class BookDetailsSiteResponse {

    private AuthorDetailsSiteResponse author;
    
    private String title;

    private String synopsis;

    private String summary;

    private Double price;

    private Integer numberPages;

    private String isbn;

    private LocalDate publicationDate;
    
    public BookDetailsSiteResponse(Book book) {
        author = new AuthorDetailsSiteResponse(book.getAuthor());
        this.title = book.getTitle();
        this.synopsis = book.getSynopsis();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberPages = book.getNumberPages();
        this.isbn = book.getIsbn();
        this.publicationDate = book.getPublicationDate();
    }

    public AuthorDetailsSiteResponse getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}
