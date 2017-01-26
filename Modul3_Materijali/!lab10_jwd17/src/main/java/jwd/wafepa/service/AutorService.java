package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Autor;

import org.springframework.data.domain.Page;

public interface AutorService {
	
	Autor findOne(Long id);
	
	Page<Autor> findAll(int page);

	Iterable<Autor> findAll();
	
	Autor save(Autor autor);
	
	Autor delete(Long id); 
	
}
