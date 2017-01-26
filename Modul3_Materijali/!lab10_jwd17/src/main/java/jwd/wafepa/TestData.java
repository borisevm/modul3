package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Activity;
import jwd.wafepa.model.Address;
import jwd.wafepa.model.Autor;
import jwd.wafepa.model.Knjiga;
import jwd.wafepa.model.User;
import jwd.wafepa.service.ActivityService;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.service.AutorService;
import jwd.wafepa.service.KnjigaService;
import jwd.wafepa.service.UserService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private KnjigaService knjigaService;
	
	@Autowired
	private AutorService autorService;
	
	@PostConstruct
	public void init(){
//	       for (int i = 1; i <= 100; i++) {
//	            User user = new User();
//	            user.setFirstName("First name " + i);
//	            user.setLastName("Last name " + i);
//	            user.setEmail("email" + i + "@example.com");
//	            user.setPassword("123");
//	            userService.save(user);
//
//	            for (int j = 1; j <= 3; j++) {
//	                Address address = new Address();
//	                address.setNumber(j + "c/7");
//	                address.setStreat("Narodnog fronta");
//
//	                address.setUser(user);
//	                user.addAddress(address);
//	                addressService.save(address);
//	            }
//	            Activity a = new Activity("Activity_"+i);
//	            a.setUser(user);
//	            activityService.save(a);
//	       }
//		Knjiga k;
//		Autor a;
//		for (int i = 0; i < 30; i++) {
//			
//			a = new Autor("Ime_"+i, "Prezime_"+i);
//			a = autorService.save(a);
//			
//			k = new Knjiga("Naslov_"+i, "1980.");
//			k.setAutor(a);
//			knjigaService.save(k);
//		}
	
	}
}
