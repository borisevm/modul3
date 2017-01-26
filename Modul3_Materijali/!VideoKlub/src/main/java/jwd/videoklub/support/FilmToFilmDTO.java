package jwd.videoklub.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.videoklub.model.Film;
import jwd.videoklub.web.dto.FilmDTO;

@Component
public class FilmToFilmDTO implements Converter<Film, FilmDTO> {

	@Override
	public FilmDTO convert(Film film) {
		FilmDTO dto = new FilmDTO();
		dto.setId(film.getId());
		dto.setNaziv(film.getNaziv());
		dto.setZanr(film.getZanr());		
		return dto;
	}
	
	public List<FilmDTO> convert (List<Film> filmovi) {
		List<FilmDTO> retVal = new ArrayList<>();
		for(Film film : filmovi) {
			retVal.add(convert(film));
		}
		return retVal;
	}

}
