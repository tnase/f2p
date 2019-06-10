package com.print237.f2p.services;

import java.util.List;

import com.print237.f2p.entities.Posts;
import com.print237.f2p.entities.Users;

public interface UserService {
	
	Users createUser(Users user);
	
	Boolean login(String username,String password);
	
	List<Posts> addPosts(String email ,Posts post);

}
