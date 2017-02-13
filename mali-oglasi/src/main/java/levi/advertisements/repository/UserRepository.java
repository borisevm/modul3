package levi.advertisements.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import levi.advertisements.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
