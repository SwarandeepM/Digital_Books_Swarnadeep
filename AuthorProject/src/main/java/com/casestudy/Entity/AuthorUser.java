package com.casestudy.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class AuthorUser {
private String Username;
private String AuthorEmailId;
private String Password;
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int aid; 

public String getAuthorEmailId() {
	return AuthorEmailId;
}
public void setAuthorEmailId(String authorEmailId) {
	AuthorEmailId = authorEmailId;
}
public int getId() {
	return aid;
}
public void setId(int aid) {
	this.aid = aid;
}

@Override
public String toString() {
	return "AuthorUser [Username=" + Username + ", AuthorEmailId=" + AuthorEmailId + ", Password=" + Password + ", aid="
			+ aid + "]";
}
public AuthorUser(String username, String authorEmailId, String password, int aid) {
	super();
	Username = username;
	AuthorEmailId = authorEmailId;
	Password = password;
	this.aid = aid;
}
public AuthorUser() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}
