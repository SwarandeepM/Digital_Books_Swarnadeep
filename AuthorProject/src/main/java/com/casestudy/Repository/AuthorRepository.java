package com.casestudy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casestudy.Entity.AuthorUser;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorUser, Integer> {
	@Query("select a.Password from AuthorUser a where a.Username=:username")
	String findByUsername(String username);

}
