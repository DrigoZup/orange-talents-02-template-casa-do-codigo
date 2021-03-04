package br.com.zup.casadocodigo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.casadocodigo.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    
    Optional<Author> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
}
