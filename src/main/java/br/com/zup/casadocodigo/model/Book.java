package br.com.zup.casadocodigo.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String synopsis;

    private String summary;

    @Min(value = 20, message = "The price of book cannot be less than R$20,00")
    private Double price;

    @Column(name = "number_pages")
    @Min(value = 100, message = "The book cannot have less than 100 pages")
    private Integer numberPages;

    private String isbn;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "publication_date")
    @Future(message = "You cannot publish a book in the past")
    private LocalDate publicationDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String title, String synopsis, String summary, Double price, Integer numberPages,
            String isbn, LocalDate publicationDate, Category category, Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.numberPages =numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

}
