package levi.advertisements.service;

import org.springframework.data.domain.Page;

import levi.advertisements.model.User;

public interface UserService {
	
	User findOne(Long id);
	
	Page<User> findAll(int page);
	
	User save(User user);	
	
	User delete(Long id); 

}
