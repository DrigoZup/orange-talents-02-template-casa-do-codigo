package br.com.zup.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.zup.casadocodigo.model.Author;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CreateAuthorForm {

    @NotBlank(message = "The name cannot be blank")
    private String name;

    @Email(message = "Invalid format")
    @NotBlank(message = "This field cannot be blank")
    @UniqueValue(domainClass = Author.class, fieldName = "email", message = "This email is unavailable")
    private String email;

    // private String password

    @Size(max = 400, message = "You can't have more of 400 characteres")
    private String description;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
    
    public Author converter() {
        return new Author(name, description, email);
    }
}
