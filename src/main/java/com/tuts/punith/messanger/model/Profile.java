package com.tuts.punith.messanger.model;

import java.util.Date;

public class Profile
{
    private long id;
    private String message;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date createDate;

    public Profile()
    {
    }

    public Profile(long id, String message, String profileName, String firstName, String lastName, Date createDate)
    {
        this.id = id;
        this.message = message;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createDate = createDate;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getProfileName()
    {
        return profileName;
    }

    public void setProfileName(String profileName)
    {
        this.profileName = profileName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
}
