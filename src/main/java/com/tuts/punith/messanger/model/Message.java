package com.tuts.punith.messanger.model;

import java.util.Date;

public class Message
{
    private long id;
    private String message;
    private String author;
    private Date createDate;

    public Message()
    {
    }

    public Message(long id, String message, String author, Date createDate)
    {
        this.id = id;
        this.message = message;
        this.author = author;
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
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
