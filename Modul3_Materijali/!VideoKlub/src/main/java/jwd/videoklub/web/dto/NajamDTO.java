package jwd.videoklub.web.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jwd.videoklub.model.Clan;
import jwd.videoklub.model.Film;

public class NajamDTO {
	
	private Long id;	
	
	private FilmDTO film;	
	
	private ClanDTO clan;
	
	private String datum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmDTO getFilm() {
		return film;
	}

	public void setFilm(FilmDTO film) {
		this.film = film;
	}

	public ClanDTO getClan() {
		return clan;
	}

	public void setClan(ClanDTO clan) {
		this.clan = clan;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
