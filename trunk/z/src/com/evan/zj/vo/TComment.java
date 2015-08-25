package com.evan.zj.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_comment")
public class TComment extends  BaseEntity {

	// Fields

	private Integer tid;
	private Integer questionid;
	private String comment;
	private Integer creatorId;
	private Timestamp creattime;
	private Short opinion;
	private String creatorip;
	private Boolean hasfollow;
	private Integer followid;

	// Constructors

	/** default constructor */
	public TComment() {
	}

	/** full constructor */
	public TComment(Integer questionid, String comment, Integer creatorId,
			Timestamp creattime, Short opinion, String creatorip,
			Boolean hasfollow, Integer followid) {
		this.questionid = questionid;
		this.comment = comment;
		this.creatorId = creatorId;
		this.creattime = creattime;
		this.opinion = opinion;
		this.creatorip = creatorip;
		this.hasfollow = hasfollow;
		this.followid = followid;
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

	@Column(name = "comment", nullable = false, length = 16777215)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "creatorId", nullable = false)
	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "creattime", nullable = false, length = 19)
	public Timestamp getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Timestamp creattime) {
		this.creattime = creattime;
	}

	@Column(name = "opinion", nullable = false)
	public Short getOpinion() {
		return this.opinion;
	}

	public void setOpinion(Short opinion) {
		this.opinion = opinion;
	}

	@Column(name = "creatorip", nullable = false, length = 20)
	public String getCreatorip() {
		return this.creatorip;
	}

	public void setCreatorip(String creatorip) {
		this.creatorip = creatorip;
	}

	@Column(name = "hasfollow", nullable = false)
	public Boolean getHasfollow() {
		return this.hasfollow;
	}

	public void setHasfollow(Boolean hasfollow) {
		this.hasfollow = hasfollow;
	}

	@Column(name = "followid", nullable = false)
	public Integer getFollowid() {
		return this.followid;
	}

	public void setFollowid(Integer followid) {
		this.followid = followid;
	}

}