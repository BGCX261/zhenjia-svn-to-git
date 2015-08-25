package com.evan.zj.bo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.web.multipart.MultipartFile;


public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String from;

	private String[] to;

	private String[] cc;

	private String subject;

	private String content;

	private MultipartFile[] attachment;

	private Date sentDate;

	public MultipartFile[] getAttachment() {
		return attachment;
	}

	public String[] getCc() {
		return cc;
	}

	public String getContent() {
		return content;
	}

	public String getFrom() {
		return from;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public String getSubject() {
		return subject;
	}

	public String[] getTo() {
		return to;
	}

	public void setAttachment(MultipartFile[] attachment) {
		this.attachment = attachment;
	}

	public void setCc(String ccAddr[]) {
		this.cc = ccAddr;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setFrom(String fromAddr) {
		this.from = fromAddr;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTo(String[] toAddr) {
		this.to = toAddr;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

