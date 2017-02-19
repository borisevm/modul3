package levi.advertisements.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import levi.advertisements.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	public User findByUserName(String userName); 

}
