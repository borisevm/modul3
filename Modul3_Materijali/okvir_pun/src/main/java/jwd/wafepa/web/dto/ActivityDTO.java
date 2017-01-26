package jwd.wafepa.web.dto;

public class ActivityDTO {
	private Long id;
	private String name;
	private UserDTO user;
	
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ActivityDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}
