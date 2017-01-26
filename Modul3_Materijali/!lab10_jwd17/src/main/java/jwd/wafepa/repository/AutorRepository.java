package jwd.wafepa.repository;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Autor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends PagingAndSortingRepository<Autor, Long>{
	Page<Autor> findByImeContainsOrPrezimeContains(String ime,String prezime, Pageable page);

}
