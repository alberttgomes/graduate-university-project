package com.placa.mae.placamae.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialAdolescent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adolescentId;
	private String title;
	private String fieldText;
	private String fieldText1;

	public MaterialAdolescent() {
		super();
	}

	public MaterialAdolescent(long adolescentId, String title, String fieldText, String fieldText1) {
		super();
		this.adolescentId = adolescentId;
		this.title = title;
		this.fieldText = fieldText;
		this.fieldText1 = fieldText1;
	}

	public long getAdolescentId() {
		return adolescentId;
	}

	public void setAdolescentId(long adolescentId) {
		this.adolescentId = adolescentId;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFieldText() {
		return fieldText;
	}

	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}

	public String getFieldText1() {
		return fieldText1;
	}

	public void setFieldText1(String fieldText1) {
		this.fieldText1 = fieldText1;
	}

}
