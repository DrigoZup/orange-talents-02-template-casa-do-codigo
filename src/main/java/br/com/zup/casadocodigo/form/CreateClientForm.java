package br.com.zup.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import br.com.zup.casadocodigo.model.Client;
import br.com.zup.casadocodigo.model.Country;
import br.com.zup.casadocodigo.model.State;

public class CreateClientForm {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String town;
    @NotNull
    private Long idCountry;

    private Long idState;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String zip;

    public CreateClientForm(String email, String name, String lastname, String document,
            String address, String complement, String town, Long idCountry, String phoneNumber,
            String zip) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.town = town;
        this.idCountry = idCountry;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }


    public String getDocument() {
        return document;
    }


    public boolean documentValidator() {
        Assert.hasLength(document, "field requiered");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(document, null) || cnpjValidator.isValid(document, null);
    }

    public Long getIdPais() {
        return idCountry;
    }

    public Long getIdEstado() {
        return idState;
    }

    public Client converter(EntityManager manager) {

        @NotNull
        Country country = manager.find(Country.class, idCountry);


        Client client = new Client(email, name, lastname, document, address, complement, country,
                phoneNumber, zip);

        if (idState != null) {
            client.setEstado(manager.find(State.class, idState));
        }

        return client;
    }
}
