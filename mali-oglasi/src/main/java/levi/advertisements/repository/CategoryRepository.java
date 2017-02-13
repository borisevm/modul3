package levi.advertisements.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import levi.advertisements.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
