package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.User;
import jwd.wafepa.repository.UserRepository;
import jwd.wafepa.service.UserService;

@Service
public class JpaUserService implements UserService {
	@Autowired
	private UserRepository UserRepository;

	@Override
	public User findOne(Long id) {
		return UserRepository.findOne(id);
	}

	@Override
	public Page<User> findAll(int page) {
		
		return UserRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public User save(User user) {
		return UserRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		UserRepository.delete(id);
	}
	
	@Override
	public Page<User> findByName(String name, int page) {	
		return UserRepository.findByLastNameOrFirstNameContaining(name, name, new PageRequest(page, 10));		
	}
	
//	@Override
//	public Page<User> findByFirstName(String name, int page) {			 
//		return  UserRepository.findByFirstNameContains(name, new PageRequest(page, 5));	
//	}
//	
//	
//	@Override
//	public Page<User> findByLastName(String name, int page) {	
//		return UserRepository.findByLastNameContains(name, new PageRequest(page, 5));		
//	}

//	@Override
//	public Page<User> findByName(String name, int page) {			 
//		Page<User> retVal = UserRepository.findByFirstNameContains(name, new PageRequest(page, 10));
//		if (!retVal.hasContent()) {
//			retVal = UserRepository.findByLastNameContains(name, new PageRequest(page, 10));
//		}		
//		return retVal;
//	}

}
