package jwd.agencija.web.controller;

import java.util.List;

import javax.xml.ws.Response;

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

import jwd.agencija.model.Nekretnina;
import jwd.agencija.service.NekretninaService;
import jwd.agencija.support.NekretninaDTOToNekretnina;
import jwd.agencija.support.NekretninaToNekretninaDTO;
import jwd.agencija.web.dto.NekretninaDTO;

@RestController
@RequestMapping(value = "/api/nekretnine")
public class ApiNekretninaController {
	
	@Autowired
	NekretninaService nekretninaService;
	
	@Autowired
	NekretninaToNekretninaDTO toDTO;
	
	@Autowired
	NekretninaDTOToNekretnina toNekretnina;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<NekretninaDTO>> getNekretnine(
			@RequestParam(value = "adresa", required = false) String adresa,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		Page<Nekretnina> nekretnine;
		if(adresa == null) {
			nekretnine = nekretninaService.findAll(page);
		} else {
			nekretnine = nekretninaService.findByAdresa(adresa, page);
		}
		int totalPages = nekretnine.getTotalPages();		
		HttpHeaders headers = new HttpHeaders();		
		headers.add("TotalPages", totalPages+"");
		List<Nekretnina> retVal = nekretnine.getContent();
	return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<NekretninaDTO> getNekretnina(
			@PathVariable Long id) {		
		Nekretnina nekretnina = nekretninaService.findOne(id);	
		if (nekretnina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}		
	return new ResponseEntity<>(toDTO.convert(nekretnina), HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	ResponseEntity<NekretninaDTO> delete(@PathVariable Long id) {
		Nekretnina deleted = nekretninaService.delete(id);
		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	ResponseEntity<NekretninaDTO> add(@RequestBody Nekretnina newNekretnina) {
		
		System.out.println("new nekretnina: "+newNekretnina);
		
		//Nekretnina newSaved = nekretninaService.save(toNekretnina.convert(newNekretnina));
		Nekretnina newSaved = nekretninaService.save(newNekretnina);
		
		return new ResponseEntity<>(toDTO.convert(newSaved), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<NekretninaDTO> edit(
			@RequestBody Nekretnina nekretnina,
			@PathVariable Long id) {
		if(id != nekretnina.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Nekretnina persisted = nekretninaService.save(nekretnina);
		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

}
