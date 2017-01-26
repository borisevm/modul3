package jwd.videoklub.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clan {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ime;
	
	private String prezime;
	
	private String adresa;
	
	@OneToMany(mappedBy = "clan", cascade = CascadeType.REMOVE)
	private List<Najam> najmovi = new ArrayList<>();

	public Clan() {
		super();
	}

	public Clan(String ime, String prezime, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public List<Najam> getNajmovi() {
		return najmovi;
	}

	public void setNajmovi(List<Najam> najmovi) {
		this.najmovi = najmovi;
	}	

}
