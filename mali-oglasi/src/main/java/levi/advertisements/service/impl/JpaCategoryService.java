package levi.advertisements.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import levi.advertisements.model.Category;
import levi.advertisements.repository.CategoryRepository;
import levi.advertisements.service.CategoryService;

public class JpaCategoryService implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findOne(Integer id) {		
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> findAll() {		
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {		
		return categoryRepository.save(category);
	}

	@Override
	public Category delete(Integer id) {
		Category retVal = findOne(id);
		if (retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existing category");
		}
		categoryRepository.delete(id);
		return retVal;
	}

}
