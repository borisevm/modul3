package jwd.biblioteka.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.biblioteka.model.Autor;
import jwd.biblioteka.service.AutorService;

@RestController
@RequestMapping(value = "/api/autori")
public class ApiAutorController {
	
	@Autowired
	AutorService autorService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Autor>> getAutori(
			@RequestParam(value= "name", required = false) String name,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		
		//@RequestParam(value = "page", required = false, defaultValue = "0") int page
		
		if(page != -1) {
			Page<Autor> autoriPage;
			if (name != null) {
				autoriPage = autorService.findByName(name, page);
			} else {
				autoriPage = autorService.findAll(page);
			}
			HttpHeaders headers = new HttpHeaders();
			int totalPages = autoriPage.getTotalPages();
			headers.add("TotalPages", totalPages+"");
			List<Autor> autori = autoriPage.getContent();
			return new ResponseEntity<>(autori, headers, HttpStatus.OK);
		
		} else {
		
			Iterable<Autor> autorIterable = autorService.findAll();

			List<Autor> autori = new ArrayList<>();
			for (Autor autor : autorIterable) {
				autori.add(autor);
			}
			return new ResponseEntity<>(autori, HttpStatus.OK);
		}	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<Autor> getAutor(@PathVariable Long id) {
	Autor autor = autorService.findOne(id);
	if(autor == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(autor, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	ResponseEntity<Autor> delete(@PathVariable Long id) {
		Autor deleted = autorService.delete(id);
	return new ResponseEntity<>(deleted, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<Autor> add(@RequestBody Autor newAutor) {
		Autor retVal = autorService.save(newAutor);		
	return new ResponseEntity<>(retVal, HttpStatus.CREATED);	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<Autor> edit(
			@RequestBody Autor autor,
			@PathVariable Long id) {
		if(id != autor.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Autor persisted = autorService.save(autor);
	return new ResponseEntity<>(persisted, HttpStatus.OK);	
	}	

}
