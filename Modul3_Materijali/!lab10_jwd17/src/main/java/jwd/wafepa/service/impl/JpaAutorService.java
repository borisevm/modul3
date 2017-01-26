package jwd.wafepa.service.impl;

import java.util.List;

import jwd.wafepa.model.Autor;
import jwd.wafepa.repository.AutorRepository;
import jwd.wafepa.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JpaAutorService implements AutorService{

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
	public Autor save(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public Autor delete(Long id) {
		Autor autor = autorRepository.findOne(id);
		autorRepository.delete(id);
		return autor;
	}

	@Override
	public Iterable<Autor> findAll() {
		return autorRepository.findAll();
	}

}
