package levi.advertisements.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import levi.advertisements.dto.UserDTO;
import levi.advertisements.model.User;
import levi.advertisements.repository.UserRepository;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User convert(UserDTO dto) {
		User user = null;
		if (dto.getId() == null) {
			user = new User();
		} else {
			user = userRepository.findOne(dto.getId());
			if(user == null){
				throw new IllegalStateException("Editing non-existing User");
			}
			
		}
		user.setUserName(dto.getUserName());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());		
		return user;
	}
	
	public List<User> convert(List<UserDTO> userDto) {
		List<User> retVal = new ArrayList<>();
		for (UserDTO dto : userDto) {
			retVal.add(convert(dto));
		}
		return retVal;
	}
	
	

}
