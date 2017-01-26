package jwd.videoklub.service;

import org.springframework.data.domain.Page;

import jwd.videoklub.model.Clan;

public interface ClanService {
	
	Clan findOne(Long id);
	
	Page<Clan> findAll(int page);
	
//	Iterable<Clan> findAll(); //Iterable služi za prevođenje iz Pageable
	
	Clan save(Clan clan);
	
	Clan delete(Long id);
	
	Page<Clan> findByName(String name, int page);

}
