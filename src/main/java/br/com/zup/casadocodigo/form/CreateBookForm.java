package br.com.zup.casadocodigo.form;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CreateBookForm {
    
    @NotBlank(message = "The name cannot be blank")
    @UniqueValue(domainClass = Book.class, fieldName = "title",
            message = "This title is unavailable")
    private String title;

    @Length(max = 500, message = "The synopsis cannot have more than 500 characters")
    private String synopsis;

    private String summary;

    private Double price;

    private Integer numberPages;
    

    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "this isbn already exists")
    @NotBlank(message = "This field is requiered")
    private String isbn;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
    
    @NotNull(message = "This field is requiered")
    private Long idCategory;
    
    @NotNull(message = "This field is requiered")
    private Long idAuthor;
    
    public Book converter(EntityManager manager) {
        
        Author author = manager.find(Author.class, idAuthor);
        Category category = manager.find(Category.class, idCategory);
        
        Assert.state(author == null, "Author not found");
        Assert.state(category == null, "Category nor found");
        
        return new Book( title,  synopsis,  summary,  price,  numberPages,
             isbn, publicationDate, category,  author);
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
    
    public Long getIdCategory() {
        return idCategory;
    }
    
    public Long getIdAuthor() {
        return idAuthor;
    }
    
}
