package br.com.zup.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    public Country() {
    }
    
    public Country(String name) {
        
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
