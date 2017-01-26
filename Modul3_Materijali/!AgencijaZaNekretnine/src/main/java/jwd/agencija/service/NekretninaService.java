package jwd.agencija.service;

import org.springframework.data.domain.Page;

import jwd.agencija.model.Nekretnina;

public interface NekretninaService {
	
	Nekretnina findOne(Long id);
	
	Page<Nekretnina> findAll(int page);
	
	Nekretnina save(Nekretnina nekretnina);
	
	Nekretnina delete(Long id);
	
	Page<Nekretnina> findByAdresa(String adresa, int page);

}
