package levi.advertisements;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import levi.advertisements.model.Advertisement;
import levi.advertisements.model.Category;
import levi.advertisements.model.User;
import levi.advertisements.service.AdvertisementService;
import levi.advertisements.service.CategoryService;
import levi.advertisements.service.UserService;

@Component
public class TestData {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AdvertisementService advertisementService;
	
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@PostConstruct
	public void init() {
		
//		for (int i = 1; i <= 30; i++) {
//			User user = new User();
//			user.setUserName("user_"+i);
//			user.setPassword("pass_"+i);
//			user.setFirstName("first_"+i);
//			user.setLastName("last_"+i);
//			user.setEmail("user"+i+"@mail.com");
//			user.setPhone("021-111-222");
//			user.setIsAdmin(false);
//			user.setIsApproved(true);
//			userService.save(user);			
//		
//			Category category = new Category();
//			category.setName("category_"+i);
//			category.setDescription("description_"+i);
//			categoryService.save(category);	
//			
//			Advertisement advertisement = new Advertisement();
//			advertisement.setTitle("title_"+i);
//			try {
//			advertisement.setDateStart(formatter.parse("2017-01-01"));
//			advertisement.setDateEnd(formatter.parse("2017-02-01"));
//			} catch (ParseException e) {				
//				e.printStackTrace();				
//			}
//			advertisement.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry."
//					+ " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
//					+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book. "
//					+ "It has survived not only five centuries, but also the leap into electronic typesetting, "
//					+ "remaining essentially unchanged.");
//			advertisement.setAuthor(user);
//			advertisement.setCategory(category);
//			advertisementService.save(advertisement);
//			
//		}	
		
	}

}
