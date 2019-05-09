package com.print237.f2p.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.print237.f2p.entities.Users;
import com.print237.f2p.services.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired UserService userService ;
	
	//SAVE USER
		@PostMapping("/save")
		public ResponseEntity<Users> saveUsers(@RequestBody Users user){
			Users  result =userService.createUser(user);
			return new ResponseEntity<Users>(result,HttpStatus.OK);
		}

}
