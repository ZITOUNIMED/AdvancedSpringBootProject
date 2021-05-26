package com.example.tutosSpringBoot.rest.open;

import com.example.tutosSpringBoot.config.jwt.JwtTokenProvider;
import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.repositories.PersonRepository;
import com.example.tutosSpringBoot.rest.requests.LoginRequest;
import com.example.tutosSpringBoot.rest.responses.AuthResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/open/auth")
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		try {
			String email = request.getEmail();
			String password = request.getPassword();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

			Person person = personRepository.findByEmail(email);
			if (person == null) {
				throw new UsernameNotFoundException("E-mail " + email + "not found");
			}

			String token = jwtTokenProvider.createToken(email, person.getRole());
			AuthResponse authResponse = new AuthResponse();
			authResponse.setEmail(email);
            authResponse.setToken(token);

			return ResponseEntity.ok(authResponse);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}

	/*
	@PostMapping("/signup")
	public ResponseEntity signup(@RequestBody SignUpRequest request) {
		try {
			String username = request.getUsername();
			String password = request.getPassword();
			String passwordConfirm = request.getPasswordConfirm();

			User existingUser = userRepository.findByUsername(username);
			if (existingUser != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is already user!");
			}

			// a digit must occur at least once
			// a lower case letter must occur at least once
			// an upper case letter must occur at least once
			// a special character must occur at least once
			// no whitespace allowed in the entire string
			// anything, at least 10 places though
			Pattern passwordPattern = Pattern
					.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[@#$%^&+=]).{10,}$");
			Matcher m = passwordPattern.matcher(password);
			if (!m.matches()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid password!");
			}

			if (!password.equals(passwordConfirm)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Passwords are different!");
			}

			Role role = roleRepository.findByName(RoleEnum.ROLE_USER.getName());

			User user = new User();
			user.setUsername(username);
			user.setPassword(passwordEncoder.encode(password));
			user.setRoles(Arrays.asList(role));
			user.setEnable(false);
			user.setFirstname(request.getFirstname());
			user.setLastname(request.getLastname());
			user.setEmail(request.getEmail());

			userRepository.save(user);

			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid cridentials!");
		}
	}*/
}
