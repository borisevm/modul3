package jwd.wafepa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.User;

@Repository
public interface UserRepository 
	extends PagingAndSortingRepository<User, Long> {
	
	Page<User> findByLastNameLike(String lastName, Pageable pageRequest);

}
