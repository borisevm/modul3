package jwd.videoklub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Najam {
	
	@Id
	@GeneratedValue
	@Column(name = "najam_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private Film film;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clan_id")
	private Clan clan;
	
	private String datum;

	public Najam() {
		super();
	}

	public Najam(String datum) {
		super();
		this.datum = datum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
