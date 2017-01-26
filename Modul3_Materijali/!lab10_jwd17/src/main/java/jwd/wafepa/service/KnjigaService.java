package jwd.wafepa.service;

import jwd.wafepa.model.Knjiga;

import org.springframework.data.domain.Page;

public interface KnjigaService {
	
	Knjiga findOne(Long id);
	
	Page<Knjiga> findAll(int page);
	
	Knjiga save(Knjiga knjiga);
	
	Knjiga delete(Long id); 

}
