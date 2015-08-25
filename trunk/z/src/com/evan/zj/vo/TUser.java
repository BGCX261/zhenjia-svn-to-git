package com.evan.zj.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user")
public class TUser extends  BaseEntity{

	private Integer tid;
	private String name;
	private String password;
	private Boolean enable;
	private Short bindtype;
	private String bindId;
	private String displayname;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String name, String password, Boolean enable, Short bindtype,
			String bindId, String displayname) {
		this.name = name;
		this.password = password;
		this.enable = enable;
		this.bindtype = bindtype;
		this.bindId = bindId;
		this.displayname = displayname;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "tid", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enable", nullable = false)
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Column(name = "bindtype", nullable = false)
	public Short getBindtype() {
		return this.bindtype;
	}

	public void setBindtype(Short bindtype) {
		this.bindtype = bindtype;
	}

	@Column(name = "bindId", nullable = false, length = 50)
	public String getBindId() {
		return this.bindId;
	}

	public void setBindId(String bindId) {
		this.bindId = bindId;
	}

	@Column(name = "displayname", nullable = false, length = 30)
	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

}