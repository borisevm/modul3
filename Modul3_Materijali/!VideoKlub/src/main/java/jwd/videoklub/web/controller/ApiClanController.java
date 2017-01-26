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

import jwd.videoklub.model.Clan;
import jwd.videoklub.service.ClanService;
import jwd.videoklub.support.ClanToClanDTO;
import jwd.videoklub.web.dto.ClanDTO;

@RestController
@RequestMapping(value = "/api/clanovi")
public class ApiClanController {
	
	@Autowired
	ClanService clanService;
	@Autowired
	ClanToClanDTO toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<ClanDTO>> getAll(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
		
		Page<Clan> retVal;
		if(name == null){
			retVal = clanService.findAll(page);
		} else {
			retVal = clanService.findByName(name, page);
		}
			
		List<Clan> retValLista = retVal.getContent();		
		HttpHeaders headers = new HttpHeaders();
		int totalPages = retVal.getTotalPages();
		headers.add("TotalPages", totalPages+"");
		return new ResponseEntity<>(toDto.convert(retValLista), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{id}")
	ResponseEntity<ClanDTO> getOne (@PathVariable Long id) {
		
		Clan retVal = clanService.findOne(id);
		if(retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{id}")
	ResponseEntity<ClanDTO> delete(@PathVariable Long id) {
		Clan deleted = clanService.delete(id);
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	ResponseEntity<ClanDTO> add(@RequestBody Clan newEntity) {
		Clan retVal = clanService.save(newEntity); 
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<ClanDTO> edit(
			@RequestBody Clan entity,
			@PathVariable Long id) {
		
		if(id != entity.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Clan persisted = clanService.save(entity);
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}

}
