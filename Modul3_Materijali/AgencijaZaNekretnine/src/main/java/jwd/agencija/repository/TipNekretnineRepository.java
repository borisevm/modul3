package jwd.agencija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.agencija.model.TipNekretnine;

@Repository
public interface TipNekretnineRepository extends JpaRepository<TipNekretnine, Integer> {

}
