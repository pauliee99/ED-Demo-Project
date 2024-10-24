package com.example.ed_demo.Controllers;

import java.util.List;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ed_demo.Repository.*;
import com.example.ed_demo.Entities.*;

@RestController
public class UserController {

	@Autowired
    private UserRepo userRepo;

	@Autowired
    private WorkAddrRepo workAddress;

	@Autowired
    private HomeAddrRepo homeAddress;

    @GetMapping("api/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@PostMapping("/api/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
		if(user.getId() > 0){
			return ResponseEntity.badRequest().body("Bad request: User ID must not be provided in the request.");
		}

		if (user.getWorkAddress() != null) {
			workAddress.save(user.getWorkAddress());
		}
	
		if (user.getHomeAddress() != null) {
			homeAddress.save(user.getHomeAddress());
		}

		User savedUser = userRepo.save(user);

		if (savedUser != null && savedUser.getId() > 0) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        
        return ResponseEntity.created(location).body("User created successfully with ID: " + savedUser.getId());
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error: Failed to create user.");
		}
    }
}
