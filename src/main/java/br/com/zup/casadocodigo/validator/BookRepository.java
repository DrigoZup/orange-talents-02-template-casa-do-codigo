package br.com.zup.casadocodigo.validator;

import org.springframework.data.repository.CrudRepository;
import br.com.zup.casadocodigo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
