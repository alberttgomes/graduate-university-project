package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class MaterialKids extends Material {
	private List<Posting> postingKids;

	public MaterialKids() {
		super();
	}

	public MaterialKids(String article, String articleBody, long id, String dataArticle) {
		super(article, articleBody, id, dataArticle);
	}

	public MaterialKids(List<Posting> postingKids) {
		super();
		this.postingKids = postingKids;
	}

	public List<Posting> getPostingKids() {
		return postingKids;
	}

	public void setPostingKids(List<Posting> postingKids) {
		this.postingKids = postingKids;
	}

}
