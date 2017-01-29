package jwd.agencija.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipNekretnine {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String naziv;
	
	@OneToMany(mappedBy = "tipNekretnine", cascade = CascadeType.REMOVE)
	private List<Nekretnina> nekretnine = new ArrayList<>(); 

	public TipNekretnine() {
		super();
	}

	public TipNekretnine(String naziv) {
		super();
		this.naziv = naziv;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}	
	

}
