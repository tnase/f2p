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
import javax.persistence.ManyToOne;
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

@Entity(name="Posts")
@Table(name="post")

public class Posts implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description",length = 1024)
	private String description;
	
	@ManyToOne(optional = false, cascade=CascadeType.ALL)
	@JoinColumn(name = "users_id",referencedColumnName="id")
	private Users user ;
	
	@ManyToOne(optional = true, cascade=CascadeType.ALL)
	@JoinColumn(name = "file_id",referencedColumnName="id")
	private Files file ;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "comment_id",referencedColumnName="id")
	private List<Comments> comments = new ArrayList<>();
	
	@Column(name="image", nullable = true) 
	Files image ;
	
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
