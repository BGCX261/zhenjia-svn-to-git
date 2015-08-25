package com.evan.zj.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_question")
public class TQuestion  extends  BaseEntity {

	// Fields

	private Integer tid;
	private String question;
	private String tags;
	private Integer truenum;
	private Integer falsenum;
	private Timestamp updatetime;
	private Timestamp createtime;
	private String creatorip;
	private Boolean enable;
	private Boolean editable;

	// Constructors

	/** default constructor */
	public TQuestion() {
	}

	/** full constructor */
	public TQuestion(String question, String tags, Integer truenum,
			Integer falsenum, Timestamp updatetime, Timestamp createtime,
			String creatorip, Boolean enable, Boolean editable) {
		this.question = question;
		this.tags = tags;
		this.truenum = truenum;
		this.falsenum = falsenum;
		this.updatetime = updatetime;
		this.createtime = createtime;
		this.creatorip = creatorip;
		this.enable = enable;
		this.editable = editable;
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

	@Column(name = "question", nullable = false, length = 16777215)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "tags", nullable = false, length = 200)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "truenum", nullable = false)
	public Integer getTruenum() {
		return this.truenum;
	}

	public void setTruenum(Integer truenum) {
		this.truenum = truenum;
	}

	@Column(name = "falsenum", nullable = false)
	public Integer getFalsenum() {
		return this.falsenum;
	}

	public void setFalsenum(Integer falsenum) {
		this.falsenum = falsenum;
	}

	@Column(name = "updatetime", nullable = false, length = 19)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name = "createtime", nullable = false, length = 19)
	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Column(name = "creatorip", nullable = false, length = 20)
	public String getCreatorip() {
		return this.creatorip;
	}

	public void setCreatorip(String creatorip) {
		this.creatorip = creatorip;
	}

	@Column(name = "enable", nullable = false)
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Column(name = "editable", nullable = false)
	public Boolean getEditable() {
		return this.editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

}