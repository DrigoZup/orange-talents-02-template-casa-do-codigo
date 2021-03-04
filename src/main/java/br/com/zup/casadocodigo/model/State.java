package br.com.zup.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class State {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private  String name;
    @ManyToOne
    @NotNull @Valid
    private  Country country;
    
    @Deprecated
    public State() {

    }

    public State(String nome, Country country) {
        this.name = nome;
        this.country = country;
    }

    public boolean belongCountry(Country country) {
        return this.country.equals(country);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
    
}
