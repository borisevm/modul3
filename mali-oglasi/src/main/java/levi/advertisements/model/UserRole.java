package levi.advertisements.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private int id;
	
	private String role;

}
