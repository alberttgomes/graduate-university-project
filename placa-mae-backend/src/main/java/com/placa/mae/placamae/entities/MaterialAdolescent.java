package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialAdolescent extends Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adolescentId;
	@Column
	private List<Posting> postingAdolescent;

	public MaterialAdolescent() {
		super();
	}

	public MaterialAdolescent(long materialId, String article, String articleBody, String dataArticle) {
		super(materialId, article, articleBody, dataArticle);
	}

	public MaterialAdolescent(long adolescentId, List<Posting> postingAdolescent) {
		super();
		this.adolescentId = adolescentId;
		this.postingAdolescent = postingAdolescent;
	}

	public long getAdolescentId() {
		return adolescentId;
	}

	public void setAdolescentId(long adolescentId) {
		this.adolescentId = adolescentId;
	}

	public List<Posting> getPostingAdolescent() {
		return postingAdolescent;
	}

	public void setPostingAdolescent(List<Posting> postingAdolescent) {
		this.postingAdolescent = postingAdolescent;
	}

}
