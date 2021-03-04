package br.com.zup.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.util.Assert;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CreateStateForm {

    @NotBlank
    @UniqueValue(domainClass = State.class,fieldName = "name")
    private String name;
    @NotNull
    private Long idCountry;

    public CreateStateForm(@NotBlank String name, @NotNull Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }


    public State converter(EntityManager manager) {
        
        Country country = manager.find(Country.class, idCountry);
        Assert.state(country == null, "Country not found");
        
        State state = new State(name, country);
        
        return state;
    }
}
