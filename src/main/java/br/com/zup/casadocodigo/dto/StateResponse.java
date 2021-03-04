package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;

public class StateResponse {

    private Long id;
    
    private  String name;
    
    private  Country country;
    
    public StateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = state.getCountry();
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
