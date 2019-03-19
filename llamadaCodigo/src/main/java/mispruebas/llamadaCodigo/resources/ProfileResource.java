package mispruebas.llamadaCodigo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mispruebas.model.Profile;
import mispruebas.service.ProfileService;
@Path("/profiles")
public class ProfileResource {

	
	private ProfileService profileService = new ProfileService();
	
	
	@GET 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles(); 
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("messageId")String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.addProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("messageId")String profileName) {		
		profileService.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("messageId") String profileName) {
		
		
		return profileService.getProfile(profileName);
	}
}
