package com.print237.f2p.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.print237.f2p.entities.Users;


@Repository("user")

public interface UserRepository extends JpaRepository<Users, Long> {
	
	public  Users  findByEmail(String email); 

}
