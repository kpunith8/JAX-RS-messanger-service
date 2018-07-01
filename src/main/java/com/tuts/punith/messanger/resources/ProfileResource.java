package com.tuts.punith.messanger.resources;

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

import com.tuts.punith.messanger.model.Profile;
import com.tuts.punith.messanger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class ProfileResource
{
    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles()
    {
        return profileService.getProfiles();
    }

    @POST
    public Profile addProfile(Profile Profile)
    {
        return profileService.addProfile(Profile);
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile Profile)
    {
        Profile.setProfileName(profileName);

        return profileService.updateProfile(Profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String profileName)
    {
        return profileService.removeProfile(profileName);
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName)
    {
        return profileService.getProfile(profileName);
    }
}
