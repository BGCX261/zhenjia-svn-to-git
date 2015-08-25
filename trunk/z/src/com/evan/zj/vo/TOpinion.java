package com.evan.zj.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TOpinion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_opinion")
public class TOpinion extends  BaseEntity {

	// Fields

	private Integer tid;
	private Integer questionid;
	private Short opinion;
	private Integer userid;
	private Timestamp createtime;
	private String creatorip;

	// Constructors

	/** default constructor */
	public TOpinion() {
	}

	/** full constructor */
	public TOpinion(Integer questionid, Short opinion, Integer userid,
			Timestamp createtime, String creatorip) {
		this.questionid = questionid;
		this.opinion = opinion;
		this.userid = userid;
		this.createtime = createtime;
		this.creatorip = creatorip;
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

	@Column(name = "questionid", nullable = false)
	public Integer getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}

	@Column(name = "opinion", nullable = false)
	public Short getOpinion() {
		return this.opinion;
	}

	public void setOpinion(Short opinion) {
		this.opinion = opinion;
	}

	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

}