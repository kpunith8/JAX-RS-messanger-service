package com.tuts.punith.messanger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message
{
    private long id;
    private String message;
    private String author;
    private Date createdDate;
    private Map<Long, Comment> comments = new HashMap<>();
    // To Build HATEOAS - links to other resources
    private List<Link> links = new ArrayList<>();

    public Message()
    {
    }

    public Message(long id, String message, String author, Date createDate)
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

    public Date getCreateDate()
    {
        return createdDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createdDate = createDate;
    }

    @XmlTransient
    public Map<Long, Comment> getComments()
    {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments)
    {
        this.comments = comments;
    }

    public List<Link> getLinks()
    {
        return links;
    }

    public void setLinks(List<Link> links)
    {
        this.links = links;
    }

    public void addLink(String url, String rel)
    {
        Link link = new Link(url, rel);

        links.add(link);
    }
}
