package levi.advertisements.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	private String description;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	List<Advertisement> advetisementsByCategory = new ArrayList<>();

	public Category() {
		super();
	}

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Advertisement> getAdvetisementsByCategory() {
		return advetisementsByCategory;
	}

	public void setAdvetisementsByCategory(List<Advertisement> advetisementsByCategory) {
		this.advetisementsByCategory = advetisementsByCategory;
	}
	
	
}
