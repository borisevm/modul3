package jwd.biblioteka.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.biblioteka.model.Knjiga;
import jwd.biblioteka.web.dto.KnjigaDTO;

@Component
public class KnjigaToKnjigaDTO implements Converter<Knjiga, KnjigaDTO> {
	
	AutorToAutorDTO autorToAutorDto = new AutorToAutorDTO();

	@Override
	public KnjigaDTO convert(Knjiga knjiga) {
		KnjigaDTO knjigaDto = new KnjigaDTO();
		knjigaDto.setId(knjiga.getId());
		knjigaDto.setNaslov(knjiga.getNaslov());
		knjigaDto.setGodinaIzdanja(knjiga.getGodinaIzdanja());
		knjigaDto.setAutor(autorToAutorDto.convert(knjiga.getAutor()));
		return knjigaDto;
	}
	
	public List<KnjigaDTO> convert (List<Knjiga> knjige) {
		List<KnjigaDTO> knjigeDto = new ArrayList<>();
		for(Knjiga knjiga : knjige) {
			knjigeDto.add(convert(knjiga));
		}
		return knjigeDto;
	}

}
