package jwd.biblioteka.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import jwd.biblioteka.model.Knjiga;

public interface KnjigaRepository extends PagingAndSortingRepository<Knjiga, Long> {
	
	Page<Knjiga> findByNaslovContaining(String naslov, Pageable page);

}
