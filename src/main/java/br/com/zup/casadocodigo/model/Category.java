package br.com.zup.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    public Category(String name) {
        
        if (name==null || name.trim().equals("")) {
            throw new IllegalArgumentException("The category needs a name");
        }
        
        this.name = name;
    }
    
    public Long getId() {
         return id;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }

}
