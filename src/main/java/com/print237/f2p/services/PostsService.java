package com.print237.f2p.services;

import com.print237.f2p.entities.Posts;

public interface PostsService {
	
	Posts createPost(Posts post);
	Boolean deletePost(String code); 

}
