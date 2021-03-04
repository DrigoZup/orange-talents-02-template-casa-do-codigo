package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import br.com.zup.casadocodigo.model.Category;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CreateCategoryForm {
    
    @NotBlank(message = "The name cannot be blank")
    @UniqueValue(domainClass = Category.class, fieldName = "name", message = "This name is unavailable")
    private String name;
    
    public CreateCategoryForm() {
    }
    
    public String getName() {
        return name;
    }
    
    public Category converter() {
        Category category = new Category(name);
        return category;
    }
}
