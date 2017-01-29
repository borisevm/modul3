package jwd.agencija.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nekretnina {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int povrsina;
	
	private int cena;
	
	private String adresa;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TipNekretnine tipNekretnine;

	
	public Nekretnina() {
		super();
	}	

	public Nekretnina(int povrsina, int cena, String adresa) {
		super();
		this.povrsina = povrsina;
		this.cena = cena;
		this.adresa = adresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public TipNekretnine getTipNekretnine() {
		return tipNekretnine;
	}

	public void setTipNekretnine(TipNekretnine tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}
	
}
