package com.example.ed_demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("api/users")
	public String welcome() {
		return "list of users";
	}
}
