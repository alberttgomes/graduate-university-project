package com.placa.mae.placamae.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialAdult extends Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adultId;
	@Column
	private List<Posting> posting;

	public MaterialAdult() {
		super();
	}

	public MaterialAdult(long materialId, String article, String articleBody, String dataArticle) {
		super(materialId, article, articleBody, dataArticle);
	}

	public MaterialAdult(long adultId, List<Posting> posting) {
		super();
		this.adultId = adultId;
		this.posting = posting;
	}

	public long getAdultId() {
		return adultId;
	}

	public void setAdultId(long adultId) {
		this.adultId = adultId;
	}

	public List<Posting> getPosting() {
		return posting;
	}

	public void setPosting(List<Posting> posting) {
		this.posting = posting;
	}

}
