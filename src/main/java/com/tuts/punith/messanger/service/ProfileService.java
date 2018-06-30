package com.tuts.punith.messanger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tuts.punith.messanger.database.MessageDataBase;
import com.tuts.punith.messanger.model.Profile;

public class ProfileService
{
    Map<String, Profile> profiles = MessageDataBase.getProfiles();

    public ProfileService()
    {
        profiles.put("kpunith8", new Profile(1, "This is Punith!", "kpunith8", "Punith", "K", new Date()));
        profiles.put("kpunith9", new Profile(2, "This is Punith here!", "kpunith9", "Punith", "K", new Date()));
    }

    public List<Profile> getProfiles()
    {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName)
    {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile)
    {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);

        return profile;
    }

    public Profile updateProfile(Profile profile)
    {
        if (profile.getProfileName().isEmpty())
        {
            return null;
        }

        profiles.put(profile.getProfileName(), profile);

        return profile;
    }

    public Profile removeProfile(String profileName)
    {
        return profiles.remove(profileName);
    }
}
