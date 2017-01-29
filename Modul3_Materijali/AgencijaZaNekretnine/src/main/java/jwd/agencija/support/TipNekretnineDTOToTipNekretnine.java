package jwd.agencija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.agencija.model.TipNekretnine;
import jwd.agencija.service.TipNekretnineService;
import jwd.agencija.web.dto.TipNekretnineDTO;

@Component
public class TipNekretnineDTOToTipNekretnine implements Converter<TipNekretnineDTO, TipNekretnine> {

	@Autowired
	TipNekretnineService tipNekretnineService;
	
	@Override
	public TipNekretnine convert(TipNekretnineDTO tnDto) {
		TipNekretnine tipNekretnine = new TipNekretnine();
		
		if(tnDto.getId() != null) {
			tipNekretnine = tipNekretnineService.findOne(tnDto.getId());
			if(tipNekretnine == null) {
				throw new IllegalStateException("Tried to modify a non-existant object");
			}
		}
		tipNekretnine.setNaziv(tnDto.getNaziv()); 
		return tipNekretnine;
	}
	
	public List<TipNekretnine> convert(List<TipNekretnineDTO> tnDtos) {
		List<TipNekretnine> retVal = new ArrayList<>();
		for(TipNekretnineDTO tnDto : tnDtos) {
			retVal.add(convert(tnDto));
		}
		return retVal;
	}
	
}
