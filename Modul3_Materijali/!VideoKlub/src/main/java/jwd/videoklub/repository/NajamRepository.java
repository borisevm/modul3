package jwd.videoklub.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.videoklub.model.Najam;

@Repository
public interface NajamRepository extends PagingAndSortingRepository<Najam, Long> {

}
