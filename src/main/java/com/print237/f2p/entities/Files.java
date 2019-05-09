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
@SuppressWarnings("serial")

@Entity(name="Files")
@Table(name="files")

public class Files implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
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
