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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ed_demo.Repository.*;
import com.example.ed_demo.Entities.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
		for (User user : users) {
			UserDTO newUserDto = new UserDTO();
			newUserDto.setId(user.getId());
			newUserDto.setFirstname(user.getFirstname());
			newUserDto.setLastname(user.getLastname());
			newUserDto.setGender(UserDTO.Gender.valueOf(user.getGender().name()));
			newUserDto.setBirthdate(user.getBirthdate());
			if (user.getWorkAddress() != null) {
				newUserDto.setWorkAddress(user.getWorkAddress().toString());
			} else {
				newUserDto.setWorkAddress(null);
			}
			if (user.getHomeAddress() != null) {
				newUserDto.setHomeAddress(user.getHomeAddress().toString());
			} else {
				newUserDto.setHomeAddress(null);
			}
			usersDto.add(newUserDto);
		}
		return usersDto;
	}

	@GetMapping("api/users/{id}")
	public UserDTO getUser(@PathVariable int id) {
		User user = userRepo.findById(id).get();
		UserDTO newUserDto = new UserDTO();
		newUserDto.setId(user.getId());
		newUserDto.setFirstname(user.getFirstname());
		newUserDto.setLastname(user.getLastname());
		newUserDto.setGender(UserDTO.Gender.valueOf(user.getGender().name()));
		newUserDto.setBirthdate(user.getBirthdate());
		if (user.getWorkAddress() != null) {
			newUserDto.setWorkAddress(user.getWorkAddress().toString());
		} else {
			newUserDto.setWorkAddress(null);
		}
		if (user.getHomeAddress() != null) {
			newUserDto.setHomeAddress(user.getHomeAddress().toString());
		} else {
			newUserDto.setHomeAddress(null);
		}
		return newUserDto;
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
