package jwd.agencija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.service.NekretninaService;
import jwd.agencija.web.dto.NekretninaDTO;

@Component
public class NekretninaDTOToNekretnina implements Converter<NekretninaDTO, Nekretnina> {

	@Autowired
	NekretninaService nekretninaService;
	
	@Autowired
	TipNekretnineDTOToTipNekretnine toTipN;
	
	@Override
	public Nekretnina convert(NekretninaDTO nekretninaDto) {
		Nekretnina nekretnina = new Nekretnina();
		
		if (nekretninaDto.getId()!=null) {
			nekretnina = nekretninaService.findOne(nekretninaDto.getId());
			if (nekretnina == null) {
				throw new IllegalStateException("Tried to modify a non-existant object");
			}
		}
		nekretnina.setPovrsina(nekretninaDto.getPovrsina());
		nekretnina.setAdresa(nekretninaDto.getAdresa());
		nekretnina.setCena(nekretninaDto.getCena());
		nekretnina.setTipNekretnine(toTipN.convert(nekretninaDto.getTipNekretnine()));
		return nekretnina;
	}
	
	public List<Nekretnina> convert(List<NekretninaDTO> nekretnineDto) {
		List<Nekretnina> retVal = new ArrayList<>();
		for(NekretninaDTO nDto : nekretnineDto) {
			retVal.add(convert(nDto));
		}
		return retVal;
	}

}
