package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialKids extends Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kidsId;
	@Column
	private List<Posting> postingKids;

	public MaterialKids() {
		super();
	}

	public MaterialKids(long materialId, String article, String articleBody, String dataArticle) {
		super(materialId, article, articleBody, dataArticle);
	}

	public MaterialKids(long kidsId, List<Posting> postingKids) {
		super();
		this.kidsId = kidsId;
		this.postingKids = postingKids;
	}

	public long getKidsId() {
		return kidsId;
	}

	public void setKidsId(long kidsId) {
		this.kidsId = kidsId;
	}

	public List<Posting> getPostingKids() {
		return postingKids;
	}

	public void setPostingKids(List<Posting> postingKids) {
		this.postingKids = postingKids;
	}

}
