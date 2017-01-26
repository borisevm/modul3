package jwd.wafepa.service.impl;

import jwd.wafepa.model.Knjiga;
import jwd.wafepa.repository.KnjigaRepository;
import jwd.wafepa.service.KnjigaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JpaKnjigaService implements KnjigaService{

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
		Knjiga retVal = findOne(id);
		if(retVal== null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant knjiga");
		}
		knjigaRepository.delete(id);
		return retVal;
	}

}
