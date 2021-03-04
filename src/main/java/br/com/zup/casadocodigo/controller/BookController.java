package br.com.zup.casadocodigo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.casadocodigo.dto.BookResponse;
import br.com.zup.casadocodigo.form.CreateBookForm;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.validator.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository repository;
    
    @PersistenceContext
    EntityManager manager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<BookResponse> saveBook(@Valid @RequestBody CreateBookForm form, UriComponentsBuilder uriBuilder) {
        Book book = form.converter(manager);
        manager.persist(book);
        
        URI uri = uriBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookResponse(book));
    }
    
    @GetMapping
    public List<BookResponse> listAllBooks() {
        List<Book> listBooks = (List<Book>) repository.findAll();
        List<BookResponse> returnedBooks = new ArrayList<BookResponse>();
        for(Book book : listBooks) {
            BookResponse newBook = new BookResponse(book);
            returnedBooks.add(newBook);
        }
        return returnedBooks;
    }
    
}
