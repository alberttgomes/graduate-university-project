package com.placa.mae.placamae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.placa.mae.placamae.repository.DAOPosting;

@Entity
public class Posting implements DAOPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postId;
	@Column
	private String title;
	@Column
	private String[] filds;
	
	@Override
	public boolean PostingIsOk(boolean res) {
		boolean posting = false;
		
		if(title != "") {
			posting = true;
			return res = posting;
		};
		
		for(int i = 0; i <= filds.length; i++) {
			
			if(filds[i] != "") {
				posting = true;
				return res = posting;
			}
			
			else if(filds[i] == "") {
				return res = false;
			}
		}
		
		return res;
	}
	
	@Override
	public String PostTitle(String title) {
		return title;
	}

	@Override
	public String[] Postfilds(String[] filds) {
		return filds;
	}

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
