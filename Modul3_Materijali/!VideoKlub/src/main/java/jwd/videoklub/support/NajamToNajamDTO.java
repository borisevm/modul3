package jwd.videoklub.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.videoklub.model.Clan;
import jwd.videoklub.model.Najam;
import jwd.videoklub.web.dto.ClanDTO;
import jwd.videoklub.web.dto.NajamDTO;

@Component
public class NajamToNajamDTO implements Converter<Najam, NajamDTO> {

	@Autowired
	ClanToClanDTO toClanDto = new ClanToClanDTO();
	@Autowired
	FilmToFilmDTO toFilmDto = new FilmToFilmDTO();
	
	
	@Override
	public NajamDTO convert(Najam najam) {	
		NajamDTO dto = new NajamDTO();
		dto.setId(najam.getId());
		dto.setClan(toClanDto.convert(najam.getClan()));
		dto.setFilm(toFilmDto.convert(najam.getFilm()));
		dto.setDatum(najam.getDatum());
		return dto;
	}
	
	public List<NajamDTO> convert (List<Najam> najmovi) {
		List<NajamDTO> retVal = new ArrayList<>();
		for(Najam najam : najmovi) {
			retVal.add(convert(najam));
		}
		return retVal;
	}
	

}
