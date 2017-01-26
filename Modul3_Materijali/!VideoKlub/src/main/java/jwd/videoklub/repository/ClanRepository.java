package jwd.videoklub.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.videoklub.model.Clan;

@Repository
public interface ClanRepository extends PagingAndSortingRepository<Clan, Long> {
	
	Page<Clan> findByImeContainingOrPrezimeContaining(String ime, String prezime, Pageable page);

}
