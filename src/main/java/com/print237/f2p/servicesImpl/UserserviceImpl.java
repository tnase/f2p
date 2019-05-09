package com.print237.f2p.servicesImpl;

import java.util.Date;

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
	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Posts addPosts(Posts post) {
		// TODO Auto-generated method stub
		return null;
	}

}
