package com.evan.zj.bo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class QuestionBO implements Serializable{
	@Field
	private Integer tid;
	@Field
	private String solrId;
	@Field
	private String question;
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Field
	private String tags;
	@Field
	private Integer truenum;
	@Field
	private Integer falsenum;
	@Field
	private Date updatetime;
	@Field
	private Date createtime;
	@Field
	private String creatorip;
	@Field
	private Boolean enable;
	@Field
	private Boolean editable;
	public Integer getTruenum() {
		return truenum;
	}
	public void setTruenum(Integer truenum) {
		this.truenum = truenum;
	}
	public Integer getFalsenum() {
		return falsenum;
	}
	public void setFalsenum(Integer falsenum) {
		this.falsenum = falsenum;
	}
	
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getCreatorip() {
		return creatorip;
	}
	public void setCreatorip(String creatorip) {
		this.creatorip = creatorip;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getSolrId() {
		return solrId;
	}
	public void setSolrId(String solrId) {
		this.solrId = solrId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	
}
