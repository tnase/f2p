package com.print237.f2p.entities;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Comment")
@Table(name="comment")
@SuppressWarnings("serial")

@Data 
public class Comments implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description")
	private String description;
	
	
	
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
