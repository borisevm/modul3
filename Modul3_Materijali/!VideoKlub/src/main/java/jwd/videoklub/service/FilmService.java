package jwd.videoklub.service;

import org.springframework.data.domain.Page;

import jwd.videoklub.model.Film;

public interface FilmService {
	
	Film findOne(Long id);
	
	Page<Film> findAll(int page);
	
	Iterable<Film> findAll(); //Iterable služi za prevođenje iz Pageable
	
	Film save(Film film);
	
	Film delete(Long id);
	
	Page<Film> findByName(String name, int page);

}
