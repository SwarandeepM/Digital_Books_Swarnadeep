package com.casestudy;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.casestudy.Entity.AuthorUser;
import com.casestudy.Service.AuthorService;

@SpringBootTest
class AuthorProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	AuthorService authorservice;

	@InjectMocks
	com.casestudy.Controller.AuthorController authorController;

	public void registerTest() {
		AuthorUser authorEntity = new AuthorUser();
		authorEntity.setAuthorEmailId("Sow@gmail.com");
		authorEntity.setId(1);
		authorEntity.setUsername("sow");
		authorEntity.setPassword("Kutti");

		when(authorservice.save(authorEntity)).thenReturn(authorEntity);

		authorController.registerUser(authorEntity);
	     System.out.println(authorEntity);
	}

}
