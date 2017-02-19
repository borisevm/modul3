package levi.advertisements.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import levi.advertisements.model.Advertisement;

public interface AdvertisementService {
	
	Advertisement findOne(Long id);
	
	Page<Advertisement> findAll(int page);
	
	Page<Advertisement> findAllSort(int page, Sort.Direction direction, String property);
	
	Advertisement save(Advertisement advertisement);	
	
	Advertisement delete(Long id); 
	
	Page<Advertisement> findByCategory(String name, int page);

}	
