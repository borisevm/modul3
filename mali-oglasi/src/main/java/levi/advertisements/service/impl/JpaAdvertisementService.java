package levi.advertisements.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import levi.advertisements.model.Advertisement;
import levi.advertisements.repository.AdvertisementRepository;
import levi.advertisements.service.AdvertisementService;

@Service
public class JpaAdvertisementService implements AdvertisementService {

	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	@Override
	public Advertisement findOne(Long id) {		
		return advertisementRepository.findOne(id);
	}	


	@Override
	public Advertisement save(Advertisement advertisement) {		
		return advertisementRepository.save(advertisement);
	}

	@Override
	public Advertisement delete(Long id) {
		Advertisement retVal = findOne(id);
		if (retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existing advertisement");
		}
		advertisementRepository.delete(id);
		return retVal;
	}

	@Override
	public Page<Advertisement> findByCategory(String name, int page) {		
		return advertisementRepository.findByCategoryName(name, new PageRequest(page, 10));
	}

	@Override
	public Page<Advertisement> findAll(int page) {
		return advertisementRepository.findAll(new PageRequest(page, 10));
	}
	
	
	public Page<Advertisement> findAllSort(int page, Sort.Direction direction, String property) {
		return advertisementRepository.findAll(new PageRequest(page, 10, new Sort(
			    new Order(direction, property))));	
	}

//	@Override
//	public Page<Advertisement> findAll(int page, Sort.Direction direction, String property) {
//		return advertisementRepository.findAll(new PageRequest(page, 10),
//		 new Sort(
//			    new Order(direction, property)));	
//	}
	

	
	
	
	
	

}
