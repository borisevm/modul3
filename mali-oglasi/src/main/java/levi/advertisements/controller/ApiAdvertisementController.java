package levi.advertisements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import levi.advertisements.dto.AdvertisementDTO;
import levi.advertisements.model.Advertisement;
import levi.advertisements.service.AdvertisementService;
import levi.advertisements.support.AdvertisementToAdvertisementDTO;

@RestController
@RequestMapping(value = "/api/advertisements")
public class ApiAdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;	
	
	@Autowired
	private AdvertisementToAdvertisementDTO toDto;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AdvertisementDTO>> getAdvertisement(						
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "direction", required = false) Sort.Direction direction,
			@RequestParam(value = "property", required = false) String property
			) {
		Page<Advertisement> retValPage;
		if (direction == null && property == null) {
			retValPage = advertisementService.findAll(page);
		} else {
			retValPage = advertisementService.findAllSort(page, direction, property);
		}
					
		
		HttpHeaders header = new HttpHeaders();
		int totalPages = retValPage.getTotalPages();
		header.add("TotalPages", totalPages+"");
		List<Advertisement> retValList = retValPage.getContent();
		return new ResponseEntity<>(toDto.convert(retValList), header, HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<AdvertisementDTO> get(
			@PathVariable Long id){
		
		Advertisement advertisement = advertisementService.findOne(id);
		
		if(advertisement==null){
			return new ResponseEntity<>(
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDto.convert(advertisement), HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<AdvertisementDTO> delete(@PathVariable Long id) {
		Advertisement deleted = advertisementService.delete(id);
		return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AdvertisementDTO> add(@RequestBody Advertisement newAdvertisement) {
		Advertisement retVal = advertisementService.save(newAdvertisement);
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<AdvertisementDTO> edit(
			@RequestBody Advertisement editedAdvertisement,
			@RequestParam Long id) {
		
		if(id != editedAdvertisement.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Advertisement retVal = advertisementService.save(editedAdvertisement);
		return new ResponseEntity<>(toDto.convert(retVal), HttpStatus.OK);
	}

}
