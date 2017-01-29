package jwd.agencija.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.service.NekretninaService;
import jwd.agencija.support.NekretninaToNekretninaDTO;
import jwd.agencija.web.dto.NekretninaDTO;

@RestController
@RequestMapping(value = "/api/tip/{tipId}/nekretnine") 
public class ApiTipNekretnineController {
	
	@Autowired
	NekretninaService nekretninaService;
	
	@Autowired
	NekretninaToNekretninaDTO toDTO;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<NekretninaDTO>> getNekretnine(
			@PathVariable Integer tipId,			
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		Page<Nekretnina> nekretnine;			
			
		nekretnine = nekretninaService.findByTipNekretnine(tipId, page);			
	
		int totalPages = nekretnine.getTotalPages();		
		HttpHeaders headers = new HttpHeaders();		
		headers.add("TotalPages", totalPages+"");
		List<Nekretnina> retVal = nekretnine.getContent();
	return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<NekretninaDTO> get(
			@PathVariable Long id, 
			@PathVariable Integer tipId){
		
		Nekretnina nekretnina = nekretninaService.findOne(id);
		
		if(nekretnina==null || tipId!=nekretnina.getTipNekretnine().getId()){
			return new ResponseEntity<>(
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDTO.convert(nekretnina), HttpStatus.OK);
	}	
}
