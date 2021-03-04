package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CreateCountryForm {

    @NotBlank
    @UniqueValue(domainClass = Country.class,fieldName =  "name")
    private String name;
    
    public void setNome(String name) {
        this.name = name;
    }
    
    public String getNome() {
        return name;
    }
}
