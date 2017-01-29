package jwd.agencija.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.agencija.model.TipNekretnine;
import jwd.agencija.repository.TipNekretnineRepository;
import jwd.agencija.service.TipNekretnineService;

@Service
public class JpaTipNekretnineService implements TipNekretnineService {
	
	@Autowired
	TipNekretnineRepository tipNekretnineRepository;

	@Override
	public TipNekretnine findOne(Integer id) {		
		return tipNekretnineRepository.findOne(id);
	}

	@Override
	public List<TipNekretnine> findAll() {
		return tipNekretnineRepository.findAll();
	}

	@Override
	public TipNekretnine save(TipNekretnine nekretnina) {		
		return tipNekretnineRepository.save(nekretnina);
	}

}
