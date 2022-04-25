package com.placa.mae.placamae.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long materialId;
	@Column
	private String article;
	@Column
	private String articleBody;
	@Column
	private String dataArticle;

	public Material() {
		super();
	}

	public Material(long materialId, String article, String articleBody, String dataArticle) {
		super();
		this.materialId = materialId;
		this.article = article;
		this.articleBody = articleBody;
		this.dataArticle = dataArticle;
	}

	public long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public String getDataArticle() {
		return dataArticle;
	}

	public void setDataArticle(String dataArticle) {
		this.dataArticle = dataArticle;
	}

}
