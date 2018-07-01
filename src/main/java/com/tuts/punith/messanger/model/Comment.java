package com.tuts.punith.messanger.model;

import java.util.Date;

public class Comment
{
    private long id;
    private String message;
    private String author;
    private Date createdDate;

    public Comment()
    {
    }

    public Comment(long id, String message, String author, Date createDate)
    {
        this.id = id;
        this.message = message;
        this.author = author;
        this.createdDate = createDate;
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }
}
