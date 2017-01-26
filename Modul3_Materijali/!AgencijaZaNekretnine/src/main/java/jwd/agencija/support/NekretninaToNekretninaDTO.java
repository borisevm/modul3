package jwd.agencija.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.web.dto.NekretninaDTO;

@Component
public class NekretninaToNekretninaDTO implements Converter<Nekretnina, NekretninaDTO> {

	TipNekretnineToTipNekretnineDTO tn2tnDto = new TipNekretnineToTipNekretnineDTO();
	
	@Override
	public NekretninaDTO convert(Nekretnina nekretnina) {
		NekretninaDTO nekretninaDto = new NekretninaDTO();
		nekretninaDto.setId(nekretnina.getId());
		nekretninaDto.setPovrsina(nekretnina.getPovrsina());
		nekretninaDto.setAdresa(nekretnina.getAdresa());
		nekretninaDto.setCena(nekretnina.getCena());
		nekretninaDto.setTipNekretnine(tn2tnDto.convert(nekretnina.getTipNekretnine()));
		return nekretninaDto;
	}
	
	public List<NekretninaDTO> convert(List<Nekretnina> nekretnine) {
		List<NekretninaDTO> retVal = new ArrayList<>();
		for(Nekretnina n : nekretnine) {
			retVal.add(convert(n));
		}
		return retVal;
	}

}
