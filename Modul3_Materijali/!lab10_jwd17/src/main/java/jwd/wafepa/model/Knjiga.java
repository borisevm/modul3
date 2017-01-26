package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Knjiga {
	
	public Knjiga() {
		super();
	}

	public Knjiga(String naslov, String godinaIzdanja) {
		super();
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;
	}

	@Id
	@GeneratedValue
	Long id;
	
	String naslov;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Autor autor;

	String godinaIzdanja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}
}
