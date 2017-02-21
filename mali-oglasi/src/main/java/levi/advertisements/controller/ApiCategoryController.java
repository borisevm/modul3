package levi.advertisements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import levi.advertisements.dto.CategoryDTO;
import levi.advertisements.model.Category;
import levi.advertisements.service.CategoryService;
import levi.advertisements.service.impl.JpaUserDetailsService;
import levi.advertisements.support.CategoryToCategoryDTO;

@RestController
@RequestMapping(value = "/api/categories")
public class ApiCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryToCategoryDTO toDto;
	
	@Autowired
	private JpaUserDetailsService userDetailsService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> getCategory() {
		List<Category> retVal = categoryService.findAll();			
		
	return new ResponseEntity<>(toDto.convert(retVal),HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<CategoryDTO> get(
			@PathVariable Integer id){
		
		Category category = categoryService.findOne(id);
		
		if(category==null){
			return new ResponseEntity<>(
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(category), HttpStatus.OK);
	}	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<CategoryDTO> delete(@PathVariable Integer id) {
		Category deleted = categoryService.delete(id);
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CategoryDTO> add(@RequestBody Category newCategory) {
		Category retVal = categoryService.save(newCategory);
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<CategoryDTO> edit(
			@RequestBody Category editedCategory,
			@RequestParam Integer id) {
		
		if(id != editedCategory.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Category retVal = categoryService.save(editedCategory);
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.OK);
	}

}
