package jwd.agencija;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.model.TipNekretnine;
import jwd.agencija.service.NekretninaService;
import jwd.agencija.service.TipNekretnineService;

@Component
public class TestData {

	@Autowired
	private TipNekretnineService tipNekretnineService;
	
	@Autowired
	private NekretninaService nekretninaService;	

	@PostConstruct
	public void init(){
		
//		TipNekretnine tn1 = new TipNekretnine("kuca");
//		tipNekretnineService.save(tn1);
//		TipNekretnine tn2 = new TipNekretnine("stan");
//		tipNekretnineService.save(tn2);
//		TipNekretnine tn3 = new TipNekretnine("plac");
//		tipNekretnineService.save(tn3);
//		
//	       for (int i = 1; i <= 10; i++) {
//	            Nekretnina n = new Nekretnina();
//	            n.setPovrsina(100);
//	            n.setAdresa("Nikole Tesle "+i+", Zabalj");
//	            n.setCena(50000);
//	            n.setTipNekretnine(tn1);
//	            nekretninaService.save(n);
//	       }
//	       for (int i = 1; i <= 10; i++) {
//	            Nekretnina n = new Nekretnina();
//	            n.setPovrsina(50);
//	            n.setAdresa("Beogradska "+i+", Novi Sad");
//	            n.setCena(30000);
//	            n.setTipNekretnine(tn2);
//	            nekretninaService.save(n);
//	       }
//	       for (int i = 1; i <= 10; i++) {
//	            Nekretnina n = new Nekretnina();
//	            n.setPovrsina(200);
//	            n.setAdresa("Novosadska "+i+", Zrenjanin");
//	            n.setCena(10000);
//	            n.setTipNekretnine(tn3);
//	            nekretninaService.save(n);
//	       }
	       
	}
}
