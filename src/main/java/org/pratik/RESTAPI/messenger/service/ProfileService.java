package org.pratik.RESTAPI.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.pratik.RESTAPI.messenger.database.DatabaseClass;
import org.pratik.RESTAPI.messenger.model.Profile;

public class ProfileService {
	
	private static long profileID=2;
	private Map<String,Profile> profiles=DatabaseClass.getProfiles();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public ProfileService() {
		profiles.put("Pratik", new Profile(1,"Pratik","Pratik"));
	}
	
	public Profile getProfile(String profilename) {
		return profiles.get(profilename);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profileID++);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
