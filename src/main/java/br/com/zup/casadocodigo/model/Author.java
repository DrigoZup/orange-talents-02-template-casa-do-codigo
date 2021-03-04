package br.com.zup.casadocodigo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    private String email;
    
    //private String password;
    
    @Column(name = "sing_in_moment")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime singInMoment;
    
    public Author() {
        
    }
    
    public Author(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.singInMoment = LocalDateTime.now();
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getSingInMoment() {
        return singInMoment;

    }

}
