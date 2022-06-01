package com.placa.mae.placamae.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialKids {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long kidsId;
		@Column(name = "title", length = 25, nullable = false)
		private String title;
		@Column(name = "field", length = 255, nullable = false)
		private String fieldText;
		@Column(name = "field_other", length = 255)
		private String fieldText1;

		public MaterialKids() {
			super();
		}

		public MaterialKids(long kidsId, String title, String fieldText, String fieldText1) {
			this.kidsId = kidsId;
			this.title = title;
			this.fieldText = fieldText;
			this.fieldText1 = fieldText1;
		}

		public long getKidsId() {
			return kidsId;
		}

		public void setKidsId(long kidsId) {
			this.kidsId = kidsId;
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
		public boolean equals(Object obj) {
			if(this == obj){
				return true;
			}
			if(obj instanceof MaterialKids) {
				MaterialKids other = (MaterialKids) obj;
				return Objects.equals(title, other.title) && Objects.equals(fieldText, other.fieldText)
								&& Objects.equals(fieldText1, other.fieldText1);
			}
			return false;
		}
		
}
