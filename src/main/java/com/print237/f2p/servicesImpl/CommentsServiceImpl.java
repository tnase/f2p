package com.print237.f2p.servicesImpl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.print237.f2p.Repository.CommentRepository;
import com.print237.f2p.entities.Comments;
import com.print237.f2p.services.CommentsService;

@Service
@Transactional

public class CommentsServiceImpl  implements CommentsService{
	
	@Autowired CommentRepository comRep ;

	@Override
	public Comments addComment(Comments comment) {
		comment.setCreatedAt(new Date());
		comment.setUpdatedAt(new Date());
	     return comRep.save(comment);
	}

	@Override
	public Boolean deleteComment(Long id) {
		Optional<Comments> comment=comRep.findById(id);
		Comments result=new Comments();
		if(comment.isPresent()) {
			result=comment.get();
			result.setDeletedAt(new Date());
			comRep.save(result);
			return true ;
		}
		return false;
	}

}
