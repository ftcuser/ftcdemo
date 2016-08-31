package com.citizant.kudos.bean;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class KudoBean implements Serializable {

	private static final long serialVersionUID = 2051924755443701471L;
	
	private String id;
	private String fromFirstName;
	private String fromLastName;
	private String fromEmail;
	private String toFirstName;
	private String toLastName;
	private String toEmail;
	private Date kudoDate;
	private String comment;
	private String attachment;
	private String kudoCategory;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromFirstName() {
		return fromFirstName;
	}
	public void setFromFirstName(String fromFirstName) {
		this.fromFirstName = fromFirstName;
	}
	public String getFromLastName() {
		return fromLastName;
	}
	public void setFromLastName(String fromLastName) {
		this.fromLastName = fromLastName;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToFirstName() {
		return toFirstName;
	}
	public void setToFirstName(String toFirstName) {
		this.toFirstName = toFirstName;
	}
	public String getToLastName() {
		return toLastName;
	}
	public void setToLastName(String toLastName) {
		this.toLastName = toLastName;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public Date getKudoDate() {
		return kudoDate;
	}
	public void setKudoDate(Date kudoDate) {
		this.kudoDate = kudoDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getKudoCategory() {
		return kudoCategory;
	}
	public void setKudoCategory(String kudoCategory) {
		this.kudoCategory = kudoCategory;
	}
	
}
