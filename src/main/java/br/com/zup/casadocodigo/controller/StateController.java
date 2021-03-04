package br.com.zup.casadocodigo.controller;

import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.casadocodigo.dto.StateResponse;
import br.com.zup.casadocodigo.form.CreateStateForm;
import br.com.zup.casadocodigo.model.State;

@RestController
@RequestMapping("/states")
public class StateController {
    
    @PersistenceContext
    EntityManager manager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<StateResponse> save(@Valid @RequestBody CreateStateForm form, UriComponentsBuilder uriBuilder) {
        State state = form.converter(manager);
        manager.persist(state);
        
        URI uri = uriBuilder.path("/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateResponse(state));
    }

}
