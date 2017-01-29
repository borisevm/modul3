package jwd.agencija.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.agencija.model.TipNekretnine;
import jwd.agencija.service.TipNekretnineService;

@RestController
@RequestMapping(value = "/api/tip")
public class ApiTipController {
	
	@Autowired
	TipNekretnineService tipNekService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TipNekretnine>> getTipoviNekretnine() {
		List<TipNekretnine> tipoviNekeretnine = tipNekService.findAll();		
	return new ResponseEntity<>(tipoviNekeretnine, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<TipNekretnine> getTipNekretnine(@PathVariable Integer id) {
		TipNekretnine tipNekeretnine = tipNekService.findOne(id);
		if(tipNekeretnine == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	return new ResponseEntity<>(tipNekeretnine, HttpStatus.OK);
	}
	
}
