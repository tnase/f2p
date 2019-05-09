package com.print237.f2p.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name="Users")
@Table(name="users")
public class Users implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="email", unique=true ,nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName="id")
	private List<Posts> posts = new ArrayList<>();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable = false)
	Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="deleted_at",nullable = true )
	Date deletedAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", nullable = true)
	Date updatedAt;

}
