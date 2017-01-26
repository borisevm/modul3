package jwd.agencija.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.agencija.model.Nekretnina;

@Repository
public interface NekretninaRepository extends PagingAndSortingRepository<Nekretnina, Long> {
	
	Page<Nekretnina> findByAdresaContaining(String adresa, Pageable page);

}
