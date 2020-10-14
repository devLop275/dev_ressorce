package com.example.jwt.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jwt.bean.AuthResponse;
import com.example.jwt.bean.User;
import com.example.jwt.service.UserServiceImpl;

@RestController
@RequestMapping("/tp-jwt/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationRest {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/signup/")
	public int signup(@RequestBody SignUpRequest user) {
		return userService.signUp(user);
	}

	@PostMapping("/admin/")
	public int adminSignup(@RequestBody SignUpRequest user) {
		return userService.adminsignUp(user);
	}

	@PostMapping("signin/login/{login}/pass/{pass}")
	public AuthResponse signin(@PathVariable String login, @PathVariable String pass) {
		return userService.authentificate(login, pass);
	}
	
	@PostMapping("signin/")
	public AuthResponse signin(@RequestBody SignInRequest signin) {
		return userService.authentificate(signin.getUsername(), signin.getPassword());
	}

	//@PreAuthorize("hasRole('ADMIN') OR hasRole('EMPLOYEE') ")
	@GetMapping("signin/{test}")
	public String signin(@PathVariable String test) {
		return test;
	}

	@GetMapping("/email/{email}")
	public Optional<User> findByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}
	
//	public Optional<User> findByEmail(String email) {
//		return userDao.findByEmail(email);
//	}
}