package com.example.ed_demo.Controllers;

import java.util.List;
import java.util.ArrayList;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserDTO> usersDto = new ArrayList<>();	
		UserDTO newUserDto = new UserDTO();
		for (User user : users) {
			if (user.getWorkAddress() != null) {
				newUserDto.setId(user.getId());
				newUserDto.setFirstname(user.getFirstname());
				newUserDto.setLastname(user.getLastname());
				newUserDto.setGender(UserDTO.Gender.valueOf(user.getGender().name()));
				newUserDto.setBirthdate(user.getBirthdate());
				newUserDto.setWorkAddress(user.getWorkAddress().toString());
				newUserDto.setHomeAddress(user.getHomeAddress().toString());
				usersDto.add(newUserDto);
			}
		}
		// return userRepo.findAll();
		return usersDto;
	}

	@PostMapping("api/users")
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

	@DeleteMapping("api/users/{id}")
    public void deleteStudent(@PathVariable int id) {
    	userRepo.deleteById(id);
    }
}
