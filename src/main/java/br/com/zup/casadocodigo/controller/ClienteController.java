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
import br.com.zup.casadocodigo.dto.ClientResponse;
import br.com.zup.casadocodigo.form.CreateClientForm;
import br.com.zup.casadocodigo.model.Client;

@RestController
@RequestMapping("/clients")
public class ClienteController {

    @PersistenceContext
    EntityManager manager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponse> saveClient(@Valid @RequestBody CreateClientForm form, UriComponentsBuilder uriBuilder) {
        
        Client client = form.converter(manager);
        manager.persist(client);
        
        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientResponse(client));
    }
}
