package com.placa.mae.placamae.entities;

public abstract class Material {

	private String article;
	private String articleBody;
	private long id;
	private String dataArticle;

	public Material() {
		super();
	}

	public Material(String article, String articleBody, long id, String dataArticle) {
		super();
		this.article = article;
		this.articleBody = articleBody;
		this.id = id;
		this.dataArticle = dataArticle;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataArticle() {
		return dataArticle;
	}

	public void setDataArticle(String dataArticle) {
		this.dataArticle = dataArticle;
	}

}
