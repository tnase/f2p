package com.print237.f2p.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.print237.f2p.entities.Users;
import com.print237.f2p.services.UserService;
@CrossOrigin(origins ="*")

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired UserService userService ;
	
	//SAVE USER
		@PostMapping("/save")
		public ResponseEntity<Users> saveUsers(@Valid @RequestBody Users user){
			System.out.println("save");
			Users  result =userService.createUser(user);
			return new ResponseEntity<Users>(result,HttpStatus.OK);
		}
		
		@GetMapping("/login")
		public ResponseEntity<Boolean> login(@RequestParam("email")String email,@RequestParam("password")String password){
			   Boolean login =userService.login(email.trim(), password.trim());
			return new ResponseEntity<Boolean>(login,HttpStatus.OK);
		}

}
