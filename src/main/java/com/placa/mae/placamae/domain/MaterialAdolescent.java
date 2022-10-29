package com.placa.mae.placamae.domain;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "materialAdolescent", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"title"})
})
public class MaterialAdolescent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adolescentId;
	@Column(name = "title", length = 25, nullable = false)
	private String title;
	@Column(name = "field", length = 255, nullable = false)
	private String fieldText;
	@Column(name = "field_other", length = 255)
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

	@Override
	public boolean equals(Object obj){
		if(this == obj) {
			return true;
		}
		if(obj instanceof MaterialAdolescent){
			MaterialAdolescent other = (MaterialAdolescent) obj;
			return Objects.equals(title, other.title) && Objects.equals(fieldText, other.fieldText)
							&& Objects.equals(fieldText1, other.fieldText);
		}
		return false;
	}

}
