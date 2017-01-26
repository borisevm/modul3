package jwd.videoklub.service;

import org.springframework.data.domain.Page;

import jwd.videoklub.model.Najam;

public interface NajamService {
	
	Najam findOne(Long id);
	
	Page<Najam> findAll(int page);	
	
	Najam save(Najam najam);
	
	Najam delete(Long id);

}
