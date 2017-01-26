package jwd.agencija.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.repository.NekretninaRepository;
import jwd.agencija.service.NekretninaService;

@Service
public class JpaNekretninaService implements NekretninaService{

	@Autowired
	NekretninaRepository nekretninaRepository;
	
	@Override
	public Nekretnina findOne(Long id) {		
		return nekretninaRepository.findOne(id);
	}

	@Override
	public Page<Nekretnina> findAll(int page) {		
		return nekretninaRepository.findAll(new PageRequest(page, 10)); 
	}

	@Override
	public Nekretnina save(Nekretnina nekretnina) {		
		return nekretninaRepository.save(nekretnina);
	}

	@Override
	public Nekretnina delete(Long id) {
		Nekretnina retVal = findOne(id);
		if(retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existing nakretnina");
		}
		nekretninaRepository.delete(id);
		return retVal;
	}

	@Override
	public Page<Nekretnina> findByAdresa(String adresa, int page) {		
		return nekretninaRepository.findByAdresaContaining(adresa, new PageRequest(page, 10));
	}

}
