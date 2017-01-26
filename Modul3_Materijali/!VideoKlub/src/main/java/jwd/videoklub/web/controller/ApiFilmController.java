package jwd.videoklub.web.controller;

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

import jwd.videoklub.model.Film;
import jwd.videoklub.service.FilmService;

@RestController
@RequestMapping(value = "/api/filmovi")
public class ApiFilmController {
	
	@Autowired	
	FilmService filmService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Film>> getAll(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		
		Page<Film> retVal;
		if(name == null){
			retVal = filmService.findAll(page);
		} else {
			retVal = filmService.findByName(name, page);
		}
			
		List<Film> retValLista = retVal.getContent();		
		HttpHeaders headers = new HttpHeaders();
		int totalPages = retVal.getTotalPages();
		headers.add("TotalPages", totalPages+"");
		return new ResponseEntity<>(retValLista, headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{id}")
	ResponseEntity<Film> getOne (@PathVariable Long id) {
		
		Film retVal = filmService.findOne(id);
		if(retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{id}")
	ResponseEntity<Film> delete(@PathVariable Long id) {
		Film deleted = filmService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	ResponseEntity<Film> add(@RequestBody Film newEntity) {
		Film retVal = filmService.save(newEntity); 
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<Film> edit(
			@RequestBody Film entity,
			@PathVariable Long id) {
		
		if(id != entity.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Film persisted = filmService.save(entity);
		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}

}
