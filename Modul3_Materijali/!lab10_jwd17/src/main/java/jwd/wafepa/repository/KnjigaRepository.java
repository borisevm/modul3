package jwd.wafepa.repository;

import jwd.wafepa.model.Knjiga;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends PagingAndSortingRepository<Knjiga, Long>{

}
