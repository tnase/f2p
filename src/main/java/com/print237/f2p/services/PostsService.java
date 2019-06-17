package com.print237.f2p.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.print237.f2p.entities.Files;
import com.print237.f2p.entities.Posts;

public interface PostsService {
	
	Posts createPost(Posts post ,MultipartFile file);
	Boolean deletePost(String code); 
	Files readFile(MultipartFile file);
	List<Posts> getPostForUser(String email);
    String getImageByPost(String filename);

}
