package jwd.videoklub.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.videoklub.model.Clan;
import jwd.videoklub.web.dto.ClanDTO;

@Component
public class ClanToClanDTO implements Converter<Clan, ClanDTO> {

	@Override
	public ClanDTO convert(Clan clan) {
		ClanDTO dto = new ClanDTO();
		dto.setId(clan.getId());
		dto.setIme(clan.getIme());
		dto.setPrezime(clan.getPrezime());
		dto.setAdresa(clan.getAdresa());
		return dto;
	}
	
	public List<ClanDTO> convert (List<Clan> clanovi) {
		List<ClanDTO> retVal = new ArrayList<>();
		for(Clan clan : clanovi) {
			retVal.add(convert(clan));
		}
		return retVal;
	}

}
