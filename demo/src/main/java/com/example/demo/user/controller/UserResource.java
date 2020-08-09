package com.example.demo.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.user.domain.User;
import com.example.demo.user.exception.UserNotFoundException;
import com.example.demo.user.service.UserDaoService;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> reteriveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/user/{id}")
	public User retrieveById(@PathVariable int id) {
		User user = userDaoService.findOne(id);
		 if(null == user) {
			 throw new UserNotFoundException("This id:"+id+" user is not found.");
		 }
		
		return user;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createdUser(@Validated @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = userDaoService.deleteById(id);
		if (null == deletedUser) {
			throw new UserNotFoundException("deleted User id: "+id+" is not found.");
		}

	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String getUserById(@RequestParam("id") String userId, Model model) {

		model.addAttribute("product", userDaoService.findOne(Integer.parseInt(userId)));
		return "product";
	}
}
