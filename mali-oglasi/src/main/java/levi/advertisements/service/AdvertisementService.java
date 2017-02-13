package levi.advertisements.service;

import org.springframework.data.domain.Page;

import levi.advertisements.model.Advertisement;

public interface AdvertisementService {
	
	Advertisement findOne(Long id);
	
	Page<Advertisement> findAll(int page);
	
	Advertisement save(Advertisement advertisement);	
	
	Advertisement delete(Long id); 
	
	Page<Advertisement> findByCategory(String name, int page);

}	
