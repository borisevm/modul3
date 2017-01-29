package jwd.agencija.service;

import java.util.List;

import jwd.agencija.model.TipNekretnine;

public interface TipNekretnineService {
	
	TipNekretnine findOne(Integer id);
	
	List<TipNekretnine> findAll();	
	
	TipNekretnine save(TipNekretnine nekretnina);

}
