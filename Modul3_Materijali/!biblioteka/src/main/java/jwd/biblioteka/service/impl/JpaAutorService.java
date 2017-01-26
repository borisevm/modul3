package jwd.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.biblioteka.model.Autor;
import jwd.biblioteka.repository.AutorRepository;
import jwd.biblioteka.service.AutorService;

@Service
public class JpaAutorService implements AutorService {

	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public Autor findOne(Long id) {		
		return autorRepository.findOne(id);
	}

	@Override
	public Page<Autor> findAll(int page) {		
		return autorRepository.findAll(new PageRequest(page, 10));
	}
	
	@Override
	public Iterable<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public Autor save(Autor autor) {		
		return autorRepository.save(autor) ;
	}

	@Override
	public Autor delete(Long id) {	
		Autor autor = autorRepository.findOne(id);
		if(autor == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant autor");
		}
		autorRepository.delete(autor);
		return autor;
	}

	@Override
	public Page<Autor> findByName(String name, int page) {		
		return autorRepository.findByImeContainingOrPrezimeContaining(name, name, new PageRequest(page, 10));
	}	

}
