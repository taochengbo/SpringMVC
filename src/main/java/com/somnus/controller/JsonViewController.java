package com.somnus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class JsonViewController {

	@GetMapping("/jsonview")
	@JsonView(User.SummaryView.class)
	public User getUser() {
		return new User(1L,"eric", "cc","1000@qq.com","上海市人民广场","上海");
	}
}
class User {
	public interface SummaryView {}
	public interface SummaryWithDetailView extends SummaryView{}

	@JsonView(SummaryView.class) 
	private Long id; 
	@JsonView(SummaryView.class) 
	private String firstname; 
	@JsonView(SummaryView.class) 
	private String lastname; 

	@JsonView(SummaryWithDetailView.class) 
	private String email; 
	@JsonView(SummaryWithDetailView.class) 
	private String address; 

	private String city;

	public User(Long id, String firstname, String lastname, String email,
			String address, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}