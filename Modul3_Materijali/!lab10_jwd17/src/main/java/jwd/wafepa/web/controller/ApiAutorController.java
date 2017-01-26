package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Autor;
import jwd.wafepa.service.AutorService;
import jwd.wafepa.support.AutorToAutorDTO;
import jwd.wafepa.web.dto.AutorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/autori")
public class ApiAutorController {
	
	@Autowired
	AutorService autorService;
	
	@Autowired
	AutorToAutorDTO toDTO;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<AutorDTO>> getAutori() {

		Iterable<Autor> autoriI = autorService.findAll();

		List<Autor> autori = new ArrayList<>();
	    for (Autor item : autoriI) {
	    	autori.add(item);
	    }

		return new ResponseEntity<>(toDTO.conver(autori), HttpStatus.OK);
	}

}
