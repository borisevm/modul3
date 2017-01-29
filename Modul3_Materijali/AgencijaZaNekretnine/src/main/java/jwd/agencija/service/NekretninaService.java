package jwd.agencija.service;

import org.springframework.data.domain.Page;

import jwd.agencija.model.Nekretnina;

public interface NekretninaService {
	
	Nekretnina findOne(Long id);
	
	Page<Nekretnina> findAll(int page);
	
	Nekretnina save(Nekretnina nekretnina);
	
	Nekretnina delete(Long id);
	
	Page<Nekretnina> findByAdresa(String adresa, int page);
	
	Page<Nekretnina> findByTipNekretnine(Integer id, int page);
	
//	Page<Nekretnina> findByCenaLessThan(Integer cena, int page);
	
//	Page<Nekretnina> findByCenaGreaterThan(Integer cena, int page);
	
	Page<Nekretnina> findByKriterijum(String adresa, Integer cenaOd, Integer cenaDo, int page);

}
