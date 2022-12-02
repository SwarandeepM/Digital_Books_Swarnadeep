package com.casestudy.Service;

import java.util.Optional;

import com.casestudy.Entity.AuthorUser;



public interface AuthorServiceInterface {
	public Optional<AuthorUser> getAuthorById(int authorId);
}
