package com.placa.mae.placamae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postId;
	@Column
	private String title;
	@Column
	private String[] filds;

	public Posting() {
		super();
	}

	public Posting(long postId, String title, String[] filds) {
		super();
		this.postId = postId;
		this.title = title;
		this.filds = filds;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getFilds() {
		return filds;
	}

	public void setFilds(String[] filds) {
		this.filds = filds;
	}

}
