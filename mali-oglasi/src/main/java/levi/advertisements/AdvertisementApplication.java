package levi.advertisements;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class AdvertisementApplication extends SpringBootServletInitializer{
	
	@Autowired 
	private TestData td;

	public static void main(String[] args) {
		SpringApplication.run(AdvertisementApplication.class, args);

	}
	
//	@RequestMapping("/user")
//	  public Principal user(Principal user) {
//	    return user;
//	  }

}
