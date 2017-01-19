/**
 * 
 */
package jwd.biblioteka.service;

import org.springframework.data.domain.Page;

import jwd.biblioteka.model.Knjiga;

/**
 * @author Miroslav
 *
 */
public interface KnjigaService {
	
	Knjiga findOne(Long id);
	
	Page<Knjiga> findAll(int page);
	
	Knjiga save(Knjiga knjiga);
	
	Knjiga delete(Long id);

}
