package com.example.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.jwt.bean.Admin;
import com.example.jwt.bean.AuthResponse;
import com.example.jwt.bean.Employee;
import com.example.jwt.bean.Role;
import com.example.jwt.bean.Stagiaire;
import com.example.jwt.bean.User;
import com.example.jwt.dao.UserDao;
import com.example.jwt.rest.SignUpRequest;
import com.example.jwt.security.JwtUtil;
import com.example.jwt.service.util.NumberUtil;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
    private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

		return userDao.findByEmail(s)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + s));
	}

	public int signUp(SignUpRequest user) {
		if (user == null || user.getEmail() == null || user.getEmail().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			return -1;
		}
		User loadedUser = userDao.findByEmail(user.getEmail()).orElse(null);
		if (loadedUser != null) {
			return -2;
		} else if (user.getRole() != null && !user.getRole().isEmpty()) {
			List<Role> roles = new ArrayList<>();
			for (String role : user.getRole()) {
				if (role.equals("EMPLOYEE")) {
					Role roleEmployee = roleService.findByName("ROLE_EMPLOYEE");
					roles.add(roleEmployee);
					Employee employee = new Employee();
					employee.setNom(user.getFirstName());
					employee.setEmail(user.getEmail());
					employee.setPrenom(user.getLastName());
					employee.setPassword(passwordEncoder.encode(user.getPassword()));
					employee.setAuthorities(roles);
					userDao.save(employee);
					return 0;
				}
			}
		}
		List<Role> roles = new ArrayList<>();
		Role stagiaireRole = roleService.findByName("ROLE_STAGIAIRE");
		roles.add(stagiaireRole);
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(user.getFirstName());
		stagiaire.setEmail(user.getEmail());
		stagiaire.setPrenom(user.getLastName());
		stagiaire.setPassword(passwordEncoder.encode(user.getPassword()));
		stagiaire.setAuthorities(roles);
		userDao.save(stagiaire);
		return 0;
	}

	public int adminsignUp(SignUpRequest user) {
		if (user == null || user.getEmail() == null || user.getEmail().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			return -1;
		}
		User loadedUser = userDao.findByEmail(user.getEmail()).orElse(null);
		if (loadedUser != null) {
			return -2;
		} else {
			List<Role> roles = new ArrayList<>();
			Role roleAdmin = roleService.findByName("ROLE_ADMIN");
			roles.add(roleAdmin);
			Admin admin = new Admin();
			admin.setNom(user.getFirstName());
			admin.setEmail(user.getEmail());
			admin.setPrenom(user.getLastName());
			admin.setPassword(passwordEncoder.encode(user.getPassword()));
			admin.setAuthorities(roles);
			userDao.save(admin);
			return 0;
		}
	}

	public AuthResponse authentificate(String login, String pass) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, pass));
		} catch (Exception e) {
			return null;
		}
		User userDetails = (User) loadUserByUsername(login);
		List<Role> roles = new ArrayList<>(userDetails.getAuthorities());
		return new AuthResponse(JwtUtil.generateToken(userDetails), NumberUtil.toString(userDetails.getId()),
				userDetails.getNom(), userDetails.getEmail(), roles);
	}
	
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long userId,
         @Valid @RequestBody User userDetails) {
        User user = userDao.getOne(userId);
        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setEmail(userDetails.getEmail());
        user.setVille(userDetails.getVille());
        user.setAdresse(userDetails.getAdresse());
        user.setCin(userDetails.getCin());
        user.setDatenaissance(userDetails.getDatenaissance());
        final User updatedUser = userDao.save(user);
        return ResponseEntity.ok(updatedUser);
    }

	public Optional<User> findByEmail(String email) {
		return userDao.findByEmail(email);
	}

    
}
