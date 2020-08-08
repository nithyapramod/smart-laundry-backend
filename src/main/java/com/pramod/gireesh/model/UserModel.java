package com.pramod.gireesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "phnumber")
	private String phnumber;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "macId")
	private Integer macId;
	
	@Column(name = "isOwner")
	private Boolean isOwner;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhnumber() {
		return phnumber;
	}
	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}
	public Integer getMacId() {
		return macId;
	}
	public void setMacId(Integer macId) {
		this.macId = macId;
	}
	
	public Boolean getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}
	
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", phnumber=" + phnumber + ", name=" + name + ", password=" + password
				+ ", macId=" + macId + ", isOwner=" + isOwner + "]";
	}
}
