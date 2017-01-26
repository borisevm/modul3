package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.User;

@Repository
public interface UserRepository 
	extends PagingAndSortingRepository<User, Long> {
	
//	@Query("select u from User u where u.first_name = %:name% or u.last_name = %:name%")
//	Page<User> findByLastNameOrFirstNameContains(String name, Pageable page);
	
//	Page<User> findByFirstNameContains(String firstName, Pageable page);
//	
//	Page<User> findByLastNameContains(String lastName, Pageable page);
	
	Page<User> findByLastNameOrFirstNameContaining(String lastName, String firstName, Pageable page);

}

