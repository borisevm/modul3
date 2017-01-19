package jwd.biblioteka.service;

import org.springframework.data.domain.Page;

import jwd.biblioteka.model.Autor;

public interface AutorService {
	
	Autor findOne(Long id);
	
	Page<Autor> findAll(int page);
	
	Autor save(Autor autor);
	
	Autor delete(Long id);

}
