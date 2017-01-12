package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.User;

@Repository
public interface UserRepository 
	extends PagingAndSortingRepository<User, Long> {
	
//	@Query("select u from User a where u.lastName = :lastName")
//	List<User> findByLastName(@Param("lastName") String lastName);
	
//	@Query("select u from User a where u.lastName like %:lastName%")
//	List<User> findByLastNameLike(@Param("lastName") String lastName);
	
	//	List<User> findByLastname(
//			String lastName);

}
