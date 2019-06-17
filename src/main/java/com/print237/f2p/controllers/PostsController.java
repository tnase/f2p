package com.print237.f2p.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import com.print237.f2p.Repository.UserRepository;
import com.print237.f2p.entities.Posts;
import com.print237.f2p.entities.Users;
import com.print237.f2p.services.PostsService;
@CrossOrigin(origins ="*")
@Controller
@RequestMapping("/post")
public class PostsController {
	
	@Autowired PostsService postSevice ;
	@Autowired UserRepository userRep ;
	
	@PostMapping("add")
	public  ResponseEntity<Posts>  readFile(@RequestParam(value="file",required = false) MultipartFile file,@RequestParam(value="title",required = true) String title,
			                               @RequestParam(value="description",required = false) String description
			                               ,@RequestParam(value="email",required = true) String email) throws Exception{
		  Posts   post=new Posts();
		  post.setDescription(description);
		  post.setTitle(title);
	      Users user= userRep.findByEmail(email);
		  post.setUser(user);
		  post=postSevice.createPost(post,file);
		  System.out.println(post);
		  return new ResponseEntity<Posts>(post, HttpStatus.CREATED);
		}
	
	@GetMapping("postByUser")
	public ResponseEntity<List<Posts>> getPostByUser(@RequestParam("email")String email){
		List<Posts> result=postSevice.getPostForUser(email);
		return new ResponseEntity<List<Posts>>(result,HttpStatus.OK);
	}
	
	@GetMapping("getImage")
	public ResponseEntity<String> getImageByName(@RequestParam("fileName")String fileName){
		String  result=postSevice.getImageByPost(fileName);
		System.out.println(result);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	
	
}
