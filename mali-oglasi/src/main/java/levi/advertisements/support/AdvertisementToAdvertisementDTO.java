package levi.advertisements.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import levi.advertisements.dto.AdvertisementDTO;
import levi.advertisements.model.Advertisement;

@Component
public class AdvertisementToAdvertisementDTO implements Converter<Advertisement, AdvertisementDTO> {	
	
	private UserToUserDTO toUserDto = new UserToUserDTO();
	
	private CategoryToCategoryDTO toCategoryDto = new CategoryToCategoryDTO();
	
	@Override
	public AdvertisementDTO convert(Advertisement ad) {
		AdvertisementDTO toDto = new AdvertisementDTO();
		toDto.setId(ad.getId());
		toDto.setTitle(ad.getTitle());
		toDto.setDateStart(ad.getDateStart());
		toDto.setDateEnd(ad.getDateEnd());
		toDto.setContent(ad.getContent());
		toDto.setCategory(toCategoryDto.convert(ad.getCategory()));
		toDto.setAuthor(toUserDto.convert(ad.getAuthor()));
		return toDto;
	}
	
	public List<AdvertisementDTO> convert(List<Advertisement> ads) {
		List<AdvertisementDTO> retVal = new ArrayList<>();
		for(Advertisement ad : ads) {
			retVal.add(convert(ad));
		}
		return retVal;
	}

}
