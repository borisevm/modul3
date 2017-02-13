package levi.advertisements.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import levi.advertisements.model.Advertisement;
import levi.advertisements.model.Category;

public interface AdvertisementRepository extends PagingAndSortingRepository<Advertisement, Long> {
	
	Page<Advertisement> findByDateStopBefore (Date dateStop, Pageable page);
	
	Page<Advertisement> findByDateStopAfter (Date dateStop, Pageable page);
	
	Page<Advertisement> findByCategory (Category category, Pageable page);
	
	Page<Advertisement> findByCategoryName (String name, Pageable page);

}
