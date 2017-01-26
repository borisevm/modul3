package jwd.wafepa.repository;

import java.util.List;

import jwd.wafepa.model.Activity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository 
	extends PagingAndSortingRepository<Activity, Long> {

//	@Query("select a from Activity a where a.name = :name")
//	List<Activity> findByName(@Param("name") String name);

	List<Activity> findByName(String name);
	
	List<Activity> findByNameLike(String name);
	
//	Page<Activity> findAll(Pageable page);
	
	Page<Activity> findByNameContains(String name, Pageable page); //Nova metoda za pretragu po delu imena prilagodjena prikazu sa stranicama
}
