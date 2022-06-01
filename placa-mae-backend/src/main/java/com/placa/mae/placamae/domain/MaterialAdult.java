package com.placa.mae.placamae.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialAdult {

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private long adultId;
			private String title;
			private String fieldText;
			private String fieldText1;

			public MaterialAdult() {
				super();
			}

			public MaterialAdult(long adultId, String title, String fieldText, String fieldText1) {
				this.adultId = adultId;
				this.title = title;
				this.fieldText = fieldText;
				this.fieldText1 = fieldText1;
			}

			public long getAdultId() {
				return adultId;
			}

			public void setAdultId(long adultId) {
				this.adultId = adultId;
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
				if(obj instanceof MaterialAdult){
					MaterialAdult other = (MaterialAdult) obj;
					return Objects.equals(title, other.title) && Objects.equals(fieldText, other.fieldText)
									&& Objects.equals(fieldText1, other.fieldText);
				}
				return false;
			}

}
