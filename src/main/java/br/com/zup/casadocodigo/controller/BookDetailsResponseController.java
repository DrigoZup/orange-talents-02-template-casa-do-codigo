package br.com.zup.casadocodigo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.dto.BookDetailsSiteResponse;
import br.com.zup.casadocodigo.model.Book;
import br.com.zup.casadocodigo.validator.BookRepository;

@RestController
@RequestMapping("/book/details")
public class BookDetailsResponseController {

    @Autowired
    BookRepository manager;
    
    @GetMapping(path = "{id}")
    public ResponseEntity<?> searchBook(@PathVariable Long id) {
        
        Optional<Book> searchedBook = manager.findById(id);
        if (searchedBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        BookDetailsSiteResponse response = new BookDetailsSiteResponse(searchedBook.get());
        return ResponseEntity.ok(response);
    }
}
