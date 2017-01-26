package jwd.biblioteka.web.controller;

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

import jwd.biblioteka.model.Knjiga;
import jwd.biblioteka.service.KnjigaService;
import jwd.biblioteka.support.KnjigaToKnjigaDTO;
import jwd.biblioteka.web.dto.KnjigaDTO;

@RestController
@RequestMapping(value = "/api/knjige")
public class ApiKnjigaController {
	
	@Autowired
	KnjigaService knjigaService;
	
	@Autowired
	KnjigaToKnjigaDTO toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<KnjigaDTO>> getKnjige(
			@RequestParam(value = "naslov", required = false) String naslov,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		
		Page<Knjiga> knjige;
		if(naslov == null){
			knjige = knjigaService.findAll(page);
		} else {
			knjige = knjigaService.findByName(naslov, page);
		}
			
		List<Knjiga> knjigeLista = knjige.getContent();		
		HttpHeaders headers = new HttpHeaders();
		int totalPages = knjige.getTotalPages();
		headers.add("TotalPages", totalPages+"");
		return new ResponseEntity<>(toDto.convert(knjigeLista), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{id}")
	ResponseEntity<KnjigaDTO> getKnjiga (@PathVariable Long id) {
		
		Knjiga knjiga = knjigaService.findOne(id);
		if(knjiga == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(knjiga), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{id}")
	ResponseEntity<KnjigaDTO> delete(@PathVariable Long id) {
		Knjiga deleted = knjigaService.delete(id);
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	ResponseEntity<KnjigaDTO> add(@RequestBody Knjiga newKnjiga) {
		Knjiga retVal = knjigaService.save(newKnjiga); 
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<KnjigaDTO> edit(
			@RequestBody Knjiga knjiga,
			@PathVariable Long id) {
		
		if(id != knjiga.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Knjiga persisted = knjigaService.save(knjiga);
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}
 
}
