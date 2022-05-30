package com.placa.mae.placamae.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialKids {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long kidsId;
		private String title;
		private String fieldText;
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
}
