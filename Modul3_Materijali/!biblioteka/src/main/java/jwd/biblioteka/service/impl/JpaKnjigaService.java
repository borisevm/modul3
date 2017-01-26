package jwd.biblioteka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.biblioteka.model.Knjiga;
import jwd.biblioteka.repository.KnjigaRepository;
import jwd.biblioteka.service.KnjigaService;

@Service
public class JpaKnjigaService implements KnjigaService {
	
	@Autowired
	KnjigaRepository knjigaRepository;

	@Override
	public Knjiga findOne(Long id) {
		return knjigaRepository.findOne(id);
	}

	@Override
	public Page<Knjiga> findAll(int page) {		
		return knjigaRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Knjiga save(Knjiga knjiga) {		
		return knjigaRepository.save(knjiga);
	}

	@Override
	public Knjiga delete(Long id) {
		Knjiga retVal = knjigaRepository.findOne(id);
		if(retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existing book");
		}
		knjigaRepository.delete(id);				
		return retVal;
	}

	@Override
	public Page<Knjiga> findByName(String name, int page) {		
		return knjigaRepository.findByNaslovContaining(name, new PageRequest(page, 10));
	}

}
