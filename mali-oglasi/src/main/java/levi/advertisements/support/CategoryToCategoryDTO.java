package levi.advertisements.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import levi.advertisements.dto.CategoryDTO;
import levi.advertisements.model.Category;

@Component
public class CategoryToCategoryDTO implements Converter<Category, CategoryDTO> {

	@Override
	public CategoryDTO convert(Category ctg) {
		CategoryDTO toDto = new CategoryDTO();
		toDto.setId(ctg.getId());
		toDto.setName(ctg.getName());
		toDto.setDescription(ctg.getDescription());
		return toDto;
	}
	
	public List<CategoryDTO> convert(List<Category> ctgs) {
		List<CategoryDTO> retVal = new ArrayList<>();
		for(Category ctg : ctgs) {
			retVal.add(convert(ctg));
		}
		return retVal;
	}

}
