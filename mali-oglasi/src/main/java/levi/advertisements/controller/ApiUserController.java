package levi.advertisements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import levi.advertisements.dto.UserDTO;
import levi.advertisements.dto.UserRegistrationDTO;
import levi.advertisements.model.User;
import levi.advertisements.service.UserService;
import levi.advertisements.service.impl.JpaUserDetailsService;
import levi.advertisements.support.UserDTOToUser;
import levi.advertisements.support.UserToUserDTO;

@RestController
@RequestMapping(value = "/api/users")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserToUserDTO toDto;
	
	@Autowired
	private UserDTOToUser toUser;
	
	@Autowired
	private JpaUserDetailsService userDetailsService; 
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<UserDTO>> getUser(
			@RequestParam(defaultValue = "0") int page) {
		Page<User> usersPage = userService.findAll(page);
		int totalPages = usersPage.getTotalPages();
		if (page > totalPages) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		

		List<User> users = usersPage.getContent();
		HttpHeaders header = new HttpHeaders();
		header.add("TotalPages", totalPages+"");
		
		//System.out.println(userDetailsService.loadUserByUsername(user.getUserName()));
		
		return new ResponseEntity<>(toDto.convert(users), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		User user = userService.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println(userDetailsService.loadUserByUsername(user.getUserName()));
		return new ResponseEntity<>(toDto.convert(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<UserDTO> delete(@PathVariable Long id) {
		User deleted = userService.delete(id);

		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> add(@RequestBody UserRegistrationDTO newUser) {
		if (newUser.getPassword() == null || newUser.getPassword().isEmpty()
				|| !newUser.getPassword().equals(newUser.getPasswordConfirm())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User user = new User();
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());

		User savedUser = userService.save(user);

		return new ResponseEntity<>(toDto.convert(savedUser), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<UserDTO> edit(@RequestBody UserDTO user,
			@PathVariable Long id) {

		if (id != user.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User persisted = userService.save(toUser.convert(user));

		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}

}
