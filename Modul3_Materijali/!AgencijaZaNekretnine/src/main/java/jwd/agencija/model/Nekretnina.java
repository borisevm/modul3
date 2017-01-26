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
	
	private double povrsina;
	
	private String adresa;
	
	private int cena;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TipNekretnine tipNekretnine;

	public Nekretnina() {
		super();
	}

	public Nekretnina(double povrsina, String adresa, int cena) {
		super();
		this.povrsina = povrsina;
		this.adresa = adresa;
		this.cena = cena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPovrsina() {
		return povrsina;
	}

	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public TipNekretnine getTipNekretnine() {
		return tipNekretnine;
	}

	public void setTipNekretnine(TipNekretnine tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}	

}
