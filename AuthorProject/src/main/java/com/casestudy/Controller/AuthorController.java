package com.casestudy.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.Entity.AuthorUser;
import com.casestudy.Entity.JwtRequest;
import com.casestudy.Entity.JwtResponse;
import com.casestudy.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorservice;

	@GetMapping("/getauthorid/{aid}")
	public Optional<AuthorUser> getAuthorByID(@PathVariable int aid) {
		return authorservice.getAuthorById(aid);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody AuthorUser signUpRequest) {

		AuthorUser author = new AuthorUser();
		author.setUsername(signUpRequest.getUsername());
		author.setPassword(signUpRequest.getPassword());
		author.setAuthorEmailId(signUpRequest.getAuthorEmailId());
		authorservice.save(author);
		return ResponseEntity.ok(new JwtResponse("User registered successfully"));
	}

	@PostMapping("/login")
	public String Login(@RequestBody JwtRequest author) {
		String username = author.getUsername();
		String password = author.getPassword();
		String pwd = authorservice.authenticateuser(username, password);
		// return pwd;
		if (pwd != null) {
			if (pwd.equals(password)) {
				return "success";

			} else {
				return "failure";
			}
		} else {
			return "username not exists";
		}
	}
}
