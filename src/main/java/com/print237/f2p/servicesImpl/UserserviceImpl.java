package com.print237.f2p.servicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.print237.f2p.Repository.UserRepository;
import com.print237.f2p.entities.Posts;
import com.print237.f2p.entities.Users;
import com.print237.f2p.services.UserService;

@Service
@Transactional
public class UserserviceImpl implements UserService {
     
	@Autowired UserRepository userRep ;
	
	
	@Override
	public Users createUser(Users user) {
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		return userRep.save(user);
	}

	@Override
	public Boolean login(String email, String password) {
		   Users user=userRep.findByEmail(email);
		   if(user!=null) {
			   if(password.equals(user.getPassword()))
		    return true;
		   }
		   
		   return false ;
	}

	@Override
	public List<Posts> addPosts(String email ,Posts post) {
		  Users user=userRep.findByEmail(email);
		 user= userRep.save(user) ;
		return null ;
	}

}
