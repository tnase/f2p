package com.print237.f2p.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.print237.f2p.entities.Posts;


@Repository("post")

public interface PostRepository extends JpaRepository<Posts, Long> {

}
