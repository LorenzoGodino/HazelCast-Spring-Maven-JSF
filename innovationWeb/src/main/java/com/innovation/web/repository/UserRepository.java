package com.innovation.web.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.innovation.web.model.User;

/**
 * The Interface IUserDAO.
 */

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(final Integer id);

	void deleteByName(Integer key);

	@Query("SELECT user.id FROM User user order by id")
	Set<Integer> findIds();

}
