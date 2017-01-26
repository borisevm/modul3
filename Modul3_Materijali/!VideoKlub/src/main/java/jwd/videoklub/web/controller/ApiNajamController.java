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

import jwd.videoklub.model.Najam;
import jwd.videoklub.service.NajamService;
import jwd.videoklub.support.NajamToNajamDTO;
import jwd.videoklub.web.dto.NajamDTO;

@RestController
@RequestMapping(value = "/api/najmovi")
public class ApiNajamController {
	
	@Autowired
	NajamService najamService;
	@Autowired
	NajamToNajamDTO toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<NajamDTO>> getAll(			
			@RequestParam(value = "page", required = false, defaultValue = "0") int page) {		
		
		Page<Najam> retVal = najamService.findAll(page);		
			
		List<Najam> retValLista = retVal.getContent();		
		HttpHeaders headers = new HttpHeaders();
		int totalPages = retVal.getTotalPages();
		headers.add("TotalPages", totalPages+"");
		return new ResponseEntity<>(toDto.convert(retValLista), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{id}")
	ResponseEntity<NajamDTO> getOne (@PathVariable Long id) {
		
		Najam retVal = najamService.findOne(id);
		if(retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{id}")
	ResponseEntity<NajamDTO> delete(@PathVariable Long id) {
		Najam deleted = najamService.delete(id);
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	ResponseEntity<NajamDTO> add(@RequestBody Najam newEntity) {
		Najam retVal = najamService.save(newEntity); 
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	ResponseEntity<NajamDTO> edit(
			@RequestBody Najam entity,
			@PathVariable Long id) {
		
		if(id != entity.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Najam persisted = najamService.save(entity);
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}

}
