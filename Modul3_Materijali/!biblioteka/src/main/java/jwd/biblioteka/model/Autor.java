package jwd.biblioteka.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ime;
	
	private String prezime;
	
	@OneToMany(mappedBy="autor", cascade=CascadeType.REMOVE)
	private List<Knjiga> knjige = new ArrayList<>(); 
		

	public Autor() {
		super();
	}

	public Autor(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	

}
