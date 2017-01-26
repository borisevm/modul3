package jwd.videoklub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.videoklub.model.Film;
import jwd.videoklub.repository.FilmRepository;
import jwd.videoklub.service.FilmService;

@Service
public class JpaFilmService implements FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public Film findOne(Long id) {		
		return filmRepository.findOne(id);
	}

	@Override
	public Page<Film> findAll(int page) {		
		return filmRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Iterable<Film> findAll() {		
		return filmRepository.findAll();
	}

	@Override
	public Film save(Film film) {		
		return filmRepository.save(film);
	}

	@Override
	public Film delete(Long id) {
		Film retVal = findOne(id);
		if(retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ " non-existing film");
		}
		filmRepository.delete(id);
		return retVal;
	}

	@Override
	public Page<Film> findByName(String name, int page) {		
		return filmRepository.findByNazivContaining(name, new PageRequest(page, 10));
	}

}
