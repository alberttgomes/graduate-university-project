package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class MaterialAdult extends Material {

	private List<Posting> posting;

	public MaterialAdult() {
		super();
	}

	public MaterialAdult(String article, String articleBody, long id, String dataArticle) {
		super(article, articleBody, id, dataArticle);
	}

	public MaterialAdult(List<Posting> posting) {
		super();
		this.posting = posting;
	}

	public List<Posting> getPosting() {
		return posting;
	}

}
