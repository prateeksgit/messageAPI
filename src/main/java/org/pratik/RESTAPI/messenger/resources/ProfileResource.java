package org.pratik.RESTAPI.messenger.resources;

import java.util.List;

import org.pratik.RESTAPI.messenger.model.Profile;
import org.pratik.RESTAPI.messenger.service.ProfileService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService=new ProfileService();
	
	@GET
	public List<Profile> getMessages(){
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profilename}")
	public Profile updateProfile(@PathParam("profilename") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profilename}")
	public void deleteProfile(@PathParam("profilename")String profileName,Profile profile) {
		profileService.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profilename}")
	public Profile getProfile(@PathParam("profilename")String profileName) {
		return profileService.getProfile(profileName);
	}

}
