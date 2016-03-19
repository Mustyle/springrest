package org.fool.springrest.repository;

import org.fool.springrest.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
