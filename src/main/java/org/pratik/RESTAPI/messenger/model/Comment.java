package org.pratik.RESTAPI.messenger.model;

import java.util.Date;

public class Comment {
	

	private long id;
	private Date created;
	private String message ;
	private String author;
	
	public Comment() {
		
	}
	public Comment(long id, String message, String author) {
		this.id = id;
		this.created = new Date();
		this.message = message;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String toString() {
		return "id: "+id+" message: "+message;
	}

}
