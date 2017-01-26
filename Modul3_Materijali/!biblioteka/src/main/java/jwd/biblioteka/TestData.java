package jwd.biblioteka;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.biblioteka.model.Autor;
import jwd.biblioteka.model.Knjiga;
import jwd.biblioteka.repository.AutorRepository;
import jwd.biblioteka.repository.KnjigaRepository;

@Component
public class TestData {

	@Autowired
	AutorRepository autorRepository;
	
	@Autowired
	KnjigaRepository knjigaRepository;

	@PostConstruct
	public void init(){
		
//		for(int i = 0; i <= 30; i++) {
//			Autor a = new Autor("ime_" + i, "prezime_" + i);
//			autorRepository.save(a);
//			
//			Knjiga k = new Knjiga("naziv_" + i, "2000");			
//			k.setAutor(a);
//			knjigaRepository.save(k);			
//		}      
	}
}
