package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Knjiga;
import jwd.wafepa.web.dto.KnjigaDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KnjigaToKnjigaDTO implements Converter<Knjiga, KnjigaDTO> {

	AutorToAutorDTO a2ADTO = new AutorToAutorDTO();
	
	@Override
	public KnjigaDTO convert(Knjiga knjiga) {
		KnjigaDTO knjigaDTO = new KnjigaDTO();
		knjigaDTO.setId(knjiga.getId());
		knjigaDTO.setGodinaIzdanja(knjiga.getGodinaIzdanja());
		knjigaDTO.setAutor(a2ADTO.convert(knjiga.getAutor()));
		knjigaDTO.setTitle(knjiga.getNaslov());
		return knjigaDTO;
	}

	public List<KnjigaDTO> convert(List<Knjiga> knjige){
		List<KnjigaDTO> retVal = new ArrayList<>();
		for (Knjiga knjiga : knjige) {
			retVal.add(convert(knjiga));
		}
		return retVal;
	}
	
}
