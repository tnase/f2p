package com.print237.f2p.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.print237.f2p.entities.Posts;
import com.print237.f2p.entities.Users;


@Repository

public interface PostRepository extends JpaRepository<Posts, Long> {
	@Query("SELECT post FROM Posts as post WHERE deletedAt is null and post.user=:user")
	List<Posts> getPostByUser(@Param("user") Users user);

}
