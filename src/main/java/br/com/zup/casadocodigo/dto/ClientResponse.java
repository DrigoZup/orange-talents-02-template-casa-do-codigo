package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Client;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;

public class ClientResponse {

    private Long id;
    private String email;
    private String name;
    private String lastname;
    private String document;
    private String address;
    private String complement;
    private Country country;
    private String phoneNumber;
    private String zip;
    private State state;
    
    public ClientResponse(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.name = client.getName();
        this.lastname = client.getLastname();
        this.document = client.getDocument();
        this.address = client.getAddress();
        this.complement = client.getComplement();
        this.country = client.getCountry();
        this.state = client.getState();
        this.phoneNumber = client.getPhoneNumber();
        this.zip = client.getZip();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public Country getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZip() {
        return zip;
    }

    public State getState() {
        return state;
    }
    
}
