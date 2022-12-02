package com.casestudy.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.Entity.AuthorUser;
import com.casestudy.Repository.AuthorRepository;

@Service
public class AuthorService implements AuthorServiceInterface {

	@Autowired
	private AuthorRepository authorrepo;

	public AuthorUser save(AuthorUser author) {
		return authorrepo.save(author);

	}

	public String authenticateuser(String username, String password) {
		
		String pwd = authorrepo.findByUsername(username);
		
		return pwd;
	}

	@Override
	public Optional<AuthorUser> getAuthorById(int aid) {
	   return authorrepo.findById(aid);
	}

}
