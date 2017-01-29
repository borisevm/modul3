package jwd.agencija.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.agencija.model.Nekretnina;
import jwd.agencija.model.TipNekretnine;

@Repository
public interface NekretninaRepository extends PagingAndSortingRepository<Nekretnina, Long> {
	
	Page<Nekretnina> findByAdresaContaining(String adresa, Pageable page);
	
	Page<Nekretnina> findByTipNekretnine(TipNekretnine tipNekretnine, Pageable page);
	
	Page<Nekretnina> findByTipNekretnineId(Integer id, Pageable page);
	
//	Page<Nekretnina> findByCenaLessThan(Integer cena, Pageable page);
	
//	Page<Nekretnina> findByCenaGreaterThan(Integer cena, Pageable page);
	
	Page<Nekretnina> findByAdresaContainingAndCenaGreaterThanAndCenaLessThan
		(String adresa, Integer cenaGreater, Integer cenaLess, Pageable page);

}
