package org.pratik.RESTAPI.messenger.model;

import java.util.Date;

public class Profile {
	
	private long id;
	private Date created;
	private String ProfileName;
	private String name;
	

	public Profile() {};
	
	public Profile(long id, String ProfileName,String name) {
		this.id = id;
		this.created = new Date();
		this.ProfileName = ProfileName;
		this.name=name;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getProfileName() {
		return ProfileName;
	}
	public void setProfileName(String ProfileName) {
		this.ProfileName = ProfileName;
	}
	
	

}
