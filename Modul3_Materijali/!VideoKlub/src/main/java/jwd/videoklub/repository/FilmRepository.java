package jwd.videoklub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.videoklub.model.Film;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
	
	Page<Film> findByNazivContaining(String naziv, Pageable page);

}
