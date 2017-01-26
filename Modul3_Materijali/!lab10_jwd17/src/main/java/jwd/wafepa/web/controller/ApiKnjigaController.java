package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.model.User;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.support.ActivityToActivityDTO;
import jwd.wafepa.support.KnjigaToKnjigaDTO;
import jwd.wafepa.web.dto.ActivityDTO;
import jwd.wafepa.web.dto.KnjigaDTO;
import jwd.wafepa.web.dto.UserDTO;
import jwd.wafepa.web.dto.UserRegistrationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/knjiga")
public class ApiKnjigaController {

	@Autowired 
	KnjigaService knjigaService;

	@Autowired
	private KnjigaToKnjigaDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<KnjigaDTO>> getKnjige(
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(defaultValue = "0") int page) {

		Page<Knjiga> knjige = knjigaService.findAll(page);

//		if (name != null) {
//			activities = activityService.findByName(name, page);
//		} else {
//			activities = activityService.findAll(page);
//		}
		HttpHeaders headers = new HttpHeaders();
		List<Knjiga> retVal = knjige.getContent();
		int totalPages = knjige.getTotalPages();
		headers.add("TotalPages", totalPages+"");
		return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<KnjigaDTO> add(@RequestBody Knjiga newKnjiga) {

		Knjiga retVal = knjigaService.save(newKnjiga);

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.CREATED);
	}
}
