package jwd.videoklub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Film {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String naziv;
	
	private String zanr;

	public Film() {
		super();
	}

	public Film(String naziv, String zanr) {
		super();
		this.naziv = naziv;
		this.zanr = zanr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	
	

}
