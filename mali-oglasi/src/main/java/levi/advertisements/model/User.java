package levi.advertisements.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long id;
	
	@Column(name="user_name", nullable=false)
	private String userName;
	
	@Column(nullable=false)
	private String password;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(nullable=false)
	@Email
	private String email;
	
	private String phone;
	
	@Type(type="true_false")
	@Column(nullable=false)
	private boolean isAdmin;
	
	@Type(type="true_false")
	@Column(nullable=false)
	private boolean isApproved;
	
	@OneToMany(mappedBy="author",cascade=CascadeType.ALL)
	private List<Advertisement> advertisments;

	public User() {
		super();
	}

	public User(String userName, String password, String firstName, String lastName, String email, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public List<Advertisement> getAdvertisments() {
		return advertisments;
	}

	public void setAdvertisments(List<Advertisement> advertisments) {
		this.advertisments = advertisments;
	}	
	
	

}
