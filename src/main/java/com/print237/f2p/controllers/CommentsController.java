package com.print237.f2p.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.print237.f2p.entities.Comments;
import com.print237.f2p.services.CommentsService;


@Controller
@RequestMapping("/comment")
public class CommentsController {

	@Autowired
	CommentsService commentService;
	
	//SAVE COMMENT 
	@PostMapping("/save")
	public ResponseEntity<Comments> saveComment(@RequestBody Comments comment){
		Comments  result =commentService.addComment(comment);
		return new ResponseEntity<Comments>(result,HttpStatus.OK);
	}
	
	@GetMapping("/delete")
	public ResponseEntity<Boolean> deleteComment(@RequestParam("id")Long comment_id){
		Boolean  result =commentService.deleteComment(comment_id);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
}
