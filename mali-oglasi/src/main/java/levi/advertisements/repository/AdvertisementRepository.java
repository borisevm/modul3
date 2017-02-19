package levi.advertisements.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import levi.advertisements.model.Advertisement;
import levi.advertisements.model.Category;

@Repository
public interface AdvertisementRepository extends PagingAndSortingRepository<Advertisement, Long> {
	
	Page<Advertisement> findByDateEndBefore (Date dateEnd, Pageable page);
	
	Page<Advertisement> findByDateEndAfter (Date dateEnd, Pageable page);
	
	Page<Advertisement> findByCategory (Category category, Pageable page);
	
	Page<Advertisement> findByCategoryName (String name, Pageable page);

//	Page<Advertisement> findAllSortable(Pageable page, Sort sort);		

}
