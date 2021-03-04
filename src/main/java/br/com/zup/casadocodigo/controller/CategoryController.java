package br.com.zup.casadocodigo.controller;

import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.casadocodigo.dto.CategoryResponse;
import br.com.zup.casadocodigo.form.CreateCategoryForm;
import br.com.zup.casadocodigo.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryResponse> saveCategory(@Validated @RequestBody CreateCategoryForm form, UriComponentsBuilder uriBuilder) {
        Category category = form.converter();
        manager.persist(category);
        
        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoryResponse(category));
    }
}
