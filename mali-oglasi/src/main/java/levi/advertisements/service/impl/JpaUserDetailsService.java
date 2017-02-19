package levi.advertisements.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import levi.advertisements.model.User;
import levi.advertisements.repository.UserRepository;

@Component
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(userName);
		
		if(user == null || !user.getIsApproved()) {
			throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist or didn't approved yet", userName));
		}
		
		// Create a granted authority based on user's role. 
		// Can't pass null authorities to user. Hence initialize with an empty arraylist
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if(user.getIsAdmin()) {
			authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
		} else {
			authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
		}			
		
		// Create a UserDetails object from the data 
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
		
		
		return userDetails;
	} 
		
		
		

}
