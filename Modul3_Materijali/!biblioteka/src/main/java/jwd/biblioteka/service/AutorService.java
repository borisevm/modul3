package jwd.biblioteka.service;

import org.springframework.data.domain.Page;

import jwd.biblioteka.model.Autor;

public interface AutorService {
	
	Autor findOne(Long id);
	
	Page<Autor> findAll(int page);
	
	Iterable<Autor> findAll(); //Iterable služi za prevođenje iz Pageable
	
	Autor save(Autor autor);
	
	Autor delete(Long id);
	
	Page<Autor> findByName(String name, int page);

}
