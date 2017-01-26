package jwd.biblioteka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import jwd.biblioteka.model.Autor;

public interface AutorRepository extends PagingAndSortingRepository<Autor, Long> {
	
	Page<Autor> findByImeContainingOrPrezimeContaining(String ime, String prezime, Pageable page);

}
