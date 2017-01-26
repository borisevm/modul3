package jwd.videoklub;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.videoklub.model.Clan;
import jwd.videoklub.model.Film;
import jwd.videoklub.model.Najam;
import jwd.videoklub.service.ClanService;
import jwd.videoklub.service.FilmService;
import jwd.videoklub.service.NajamService;

@Component
public class TestData {

	@Autowired
	private ClanService clanService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private NajamService najamService;

	@PostConstruct
	public void init(){
//	       for (int i = 1; i <= 30; i++) {
//	            Clan clan = new Clan();
//	            clan.setIme("First name " + i);
//	            clan.setPrezime("Last name " + i);
//	            clan.setAdresa("Ulica_" + i + ", Novi Sad");	         
//	            clanService.save(clan);
//	            
//	            Film film = new Film();
//	            film.setNaziv("Film " + i);
//	            film.setZanr("zanr " + i);	                    
//	            filmService.save(film);
//	            
//	            Najam najam = new Najam();	            
//	            najam.setClan(clan);
//	            najam.setFilm(film);
//	            najam.setDatum("05.09.2016.");
//	            najamService.save(najam);
//	       }
	}
}
