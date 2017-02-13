package levi.advertisements.service;

import java.util.List;

import levi.advertisements.model.Category;

public interface CategoryService {
	
	Category findOne(Integer id);
	
	List<Category> findAll();
	
	Category save(Category category);	
	
	Category delete(Integer id); 

}
