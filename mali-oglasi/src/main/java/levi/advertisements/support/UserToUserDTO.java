package levi.advertisements.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import levi.advertisements.dto.UserDTO;
import levi.advertisements.model.User;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUserName(user.getUserName());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());	
		dto.setPhone(user.getPhone());
		return dto;
	}
	
	public List<UserDTO> convert(List<User> users) {
		List<UserDTO> retVal = new ArrayList<UserDTO>();
		for (User user : users) {
			retVal.add(convert(user));
		}
		return retVal;
	}

}
