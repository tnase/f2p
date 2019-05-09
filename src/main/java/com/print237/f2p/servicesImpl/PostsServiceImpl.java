package com.print237.f2p.servicesImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.print237.f2p.entities.Posts;
import com.print237.f2p.services.PostsService;

@Service
@Transactional

public class PostsServiceImpl implements PostsService{

	@Override
	public Posts createPost(Posts post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletePost(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
