package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.casadocodigo.form.CreateCountryForm;
import br.com.zup.casadocodigo.model.Country;

@RestController
@RequestMapping("/countrys")
public class CountryController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    public Country save(CreateCountryForm form, UriComponentsBuilder uriBuilder) {
        Country country = new Country(form.getNome());

        manager.persist(country);

        return country;
    }
}
