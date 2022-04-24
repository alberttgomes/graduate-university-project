package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class MaterialAdolescent extends Material {

	private List<Posting> postingAdolescent;

	public MaterialAdolescent() {
		super();
	}

	public MaterialAdolescent(String article, String articleBody, long id, String dataArticle) {
		super(article, articleBody, id, dataArticle);
	}

	public MaterialAdolescent(List<Posting> postingAdolescent) {
		super();
		this.postingAdolescent = postingAdolescent;
	}

	public List<Posting> getPostingAdolescent() {
		return postingAdolescent;
	}

	public void setPostingAdolescent(List<Posting> postingAdolescent) {
		this.postingAdolescent = postingAdolescent;
	}

}
