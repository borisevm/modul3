package jwd.biblioteka.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import jwd.biblioteka.model.Knjiga;

public interface KnjigaRepository extends PagingAndSortingRepository<Knjiga, Long> {

}
