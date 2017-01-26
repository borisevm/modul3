package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor{

	public Autor() {
		super();
	}

	public Autor(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}

	@Id
	@GeneratedValue
	Long id;
	
	String ime;
	
	String prezime;

	@OneToMany(mappedBy="autor",cascade=CascadeType.REMOVE)
	List<Knjiga> knjige = new ArrayList<>();

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

	public List<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(List<Knjiga> knjige) {
		this.knjige = knjige;
	}
}
