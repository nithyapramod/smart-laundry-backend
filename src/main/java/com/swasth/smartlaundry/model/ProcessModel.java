package com.swasth.smartlaundry.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="process")
public class ProcessModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "processId")
	private Integer processId;
	
	@Column(name = "macUniqueId")
	private String macUniqueId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "balQuantity")
	private Integer balQuantity;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "macSlotCode")
	private String macSlotCode;
	
	@Column(name = "imageloc")
	private String imageloc;
	
	public Integer getProcessId() {
		return processId;
	}
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	public String getMacUniqueId() {
		return macUniqueId;
	}
	public void setMacUniqueId(String macUniqueId) {
		this.macUniqueId = macUniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBalQuantity() {
		return balQuantity;
	}
	public void setBalQuantity(Integer balQuantity) {
		this.balQuantity = balQuantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getMacSlotCode() {
		return macSlotCode;
	}
	public void setMacSlotCode(String macSlotCode) {
		this.macSlotCode = macSlotCode;
	}
	public String getImageloc() {
		return imageloc;
	}
	public void setImageloc(String imageloc) {
		this.imageloc = imageloc;
	}
	@Override
	public String toString() {
		return "ProcessModel [processId=" + processId + ", macUniqueId=" + macUniqueId + ", name=" + name
				+ ", balQuantity=" + balQuantity + ", price=" + price + ", macSlotCode=" + macSlotCode + ", imageloc="
				+ imageloc + "]";
	}
	
	
	
}
