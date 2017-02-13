package levi.advertisements.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import levi.advertisements.model.User;
import levi.advertisements.repository.UserRepository;
import levi.advertisements.service.UserService;

public class JpaUserService implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findOne(Long id) {		
		return userRepository.findOne(id);
	}

	@Override
	public Page<User> findAll(int page) {
		return userRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public User save(User user) {		
		return userRepository.save(user);
	}

	@Override
	public User delete(Long id) {
		User retVal = findOne(id);
		if (retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existing user");
		}
		userRepository.delete(id);
		return retVal;
	}

}
