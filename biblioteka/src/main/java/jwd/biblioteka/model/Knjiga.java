package jwd.biblioteka.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Knjiga {
	
	@Id
	@GeneratedValue 
	private Long id;
	
	private String naslov;
	
	private String godinaIzdanja;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Autor autor;

	public Knjiga() {
		super();
	}

	public Knjiga(String naslov, String godinaIzdanja) {
		super();
		this.naslov = naslov;
		this.godinaIzdanja = godinaIzdanja;		
	}

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

	public String getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(String godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}	

}
