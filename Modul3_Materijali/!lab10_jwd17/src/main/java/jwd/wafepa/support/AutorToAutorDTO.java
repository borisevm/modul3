package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Autor;
import jwd.wafepa.web.dto.AutorDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AutorToAutorDTO implements Converter<Autor, AutorDTO>  {

	@Override
	public AutorDTO convert(Autor autor) {
		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(autor.getId());
		autorDTO.setIme(autor.getIme());
		autorDTO.setPrezime(autor.getPrezime());
		return autorDTO;
	}

	public List<AutorDTO> conver(List<Autor> autori){
		List<AutorDTO> retVal = new ArrayList<>();
		for (Autor autor : autori) {
			retVal.add(convert(autor));
		}
		return retVal;
	}
	
}
