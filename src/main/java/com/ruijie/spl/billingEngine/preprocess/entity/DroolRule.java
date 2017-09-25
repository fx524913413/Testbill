package com.ruijie.spl.billingEngine.preprocess.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_drools")
public class DroolRule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String drl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDrl() {
		return drl;
	}
	public void setDrl(String drl) {
		this.drl = drl;
	}
	
	

}
