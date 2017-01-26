package jwd.biblioteka.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.biblioteka.model.Autor;
import jwd.biblioteka.web.dto.AutorDTO;

@Component
public class AutorToAutorDTO implements Converter<Autor, AutorDTO> {

	@Override
	public AutorDTO convert(Autor autor) {
		AutorDTO autorDto = new AutorDTO();
		autorDto.setId(autor.getId());
		autorDto.setIme(autor.getIme());
		autorDto.setPrezime(autor.getPrezime());
		return autorDto;
	}
	
	public List<AutorDTO> convert (List<Autor> autori) {
		List<AutorDTO> autoriDto = new ArrayList<>();
		for(Autor autor : autori) {
			autoriDto.add(convert(autor));
		}
		return autoriDto;
	}

}
