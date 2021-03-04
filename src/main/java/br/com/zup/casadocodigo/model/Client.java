package br.com.zup.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.util.Assert;

@Entity
public class Client {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String lastname;
    private String document;
    private String address;
    private String complement;
    
    @ManyToOne
    private Country country;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String zip;
    @ManyToOne
    private State state;
    

    public Client(@Email @NotBlank String email, @NotBlank String name,
            @NotBlank String lastname, @NotBlank String document,
            @NotBlank String address, @NotBlank String complement,
            @NotNull Country country, @NotBlank String phoneNumber,
            @NotBlank String zip) {
                this.email = email;
                this.name = name;
                this.lastname = lastname;
                this.document = document;
                this.address = address;
                this.complement = complement;
                this.country = country;
                this.phoneNumber = phoneNumber;
                this.zip = zip;
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

    public void setEstado(@NotNull @Valid State state) {
        Assert.notNull(country,"The country cannot be nullable");
        Assert.isTrue(state.belongCountry(country),"This state does'nt belong to this country");
        this.state = state;
    }
}
