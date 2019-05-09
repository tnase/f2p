package com.print237.f2p.services;

import com.print237.f2p.entities.Comments;

public interface CommentsService {
	
	Comments addComment(Comments comment) ;
	
	Boolean deleteComment(Long id) ;

}
