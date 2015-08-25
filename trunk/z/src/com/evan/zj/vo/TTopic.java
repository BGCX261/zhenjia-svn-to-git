package com.evan.zj.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_topic")
public class TTopic extends BaseEntity {
	// Fields
	private Integer tid;
	private String title;
	private String content;
	private String tags;
	private Integer leftnum ;
	private Integer rightnum ;
	private String leftopn;
	private String rightopn;
	private Timestamp updatetime;
	private Timestamp createtime;
	private Integer creatorid;
	private String creatorip;
	private Boolean enable ;
	private Boolean editable;
	private Integer activity;
	
	@Column(name = "activity", nullable = true)
	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	// Constructors
	/** default constructor */
	public TTopic() {
	}

	// /** full constructor */
	// public TTopic(String title, String content, String tags, Integer leftnum,
	// Integer rightnum, String leftopn, String rightopn, Timestamp updatetime,
	// Timestamp createtime, String creatorip,Integer creatorid, Boolean enable,
	// Boolean editable) {
	// this.title = title;
	// this.content = content;
	// this.tags = tags;
	// this.leftnum = leftnum;
	// this.rightnum = rightnum;
	// this.leftopn = leftopn;
	// this.rightopn = rightopn;
	// this.updatetime = updatetime;
	// this.createtime = createtime;
	// this.creatorid = creatorid;
	// this.creatorip = creatorip;
	// this.enable = enable;
	// this.editable = editable;
	// }

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "tid", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}
	@Column(name = "creatorid", nullable = false)
	public Integer getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(Integer creatorid) {
		this.creatorid = creatorid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "tags", nullable = false, length = 200)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "leftnum", nullable = true)
	public Integer getLeftnum() {
		return this.leftnum;
	}

	public void setLeftnum(Integer leftnum) {
		this.leftnum = leftnum;
	}

	@Column(name = "rightnum", nullable = true)
	public Integer getRightnum() {
		return this.rightnum;
	}

	public void setRightnum(Integer rightnum) {
		this.rightnum = rightnum;
	}

	@Column(name = "leftopn", nullable = false, length = 200)
	public String getLeftopn() {
		return this.leftopn;
	}

	public void setLeftopn(String leftopn) {
		this.leftopn = leftopn;
	}

	@Column(name = "rightopn", nullable = false, length = 200)
	public String getRightopn() {
		return this.rightopn;
	}

	public void setRightopn(String rightopn) {
		this.rightopn = rightopn;
	}

	@Column(name = "updatetime", nullable = true, length = 19)
	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Column(name = "createtime", nullable = true, length = 19)
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

	@Column(name = "enable", nullable = true)
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Column(name = "editable", nullable = true)
	public Boolean getEditable() {
		return this.editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

}