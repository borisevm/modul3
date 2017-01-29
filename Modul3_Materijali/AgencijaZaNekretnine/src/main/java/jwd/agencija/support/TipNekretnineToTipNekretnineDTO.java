package jwd.agencija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.agencija.model.TipNekretnine;
import jwd.agencija.web.dto.TipNekretnineDTO;

@Component
public class TipNekretnineToTipNekretnineDTO implements Converter<TipNekretnine, TipNekretnineDTO> {

	@Override
	public TipNekretnineDTO convert(TipNekretnine tipNekretnine) {
		TipNekretnineDTO tipNekretnineDto = new TipNekretnineDTO();
		tipNekretnineDto.setId(tipNekretnine.getId());
		tipNekretnineDto.setNaziv(tipNekretnine.getNaziv());
		return tipNekretnineDto;
	}
	
	public List<TipNekretnineDTO> convert(List<TipNekretnine> tipoviNekretnine)  {
		List<TipNekretnineDTO> retVal = new ArrayList<>();
		for(TipNekretnine tn : tipoviNekretnine) {
			retVal.add(convert(tn));
		}
		return retVal;
	}
	
}
