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

import com.tuts.punith.messanger.model.Comment;
import com.tuts.punith.messanger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class CommentResource
{
    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId)
    {
        return commentService.getAllComments(messageId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment)
    {
        return commentService.addComment(messageId, comment);
    }

    @GET
    @Path("/{commentId}")
    public Comment getCommentById(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
    {
        return commentService.getCommentById(messageId, commentId);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
            Comment comment)
    {
        comment.setId(commentId);

        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId)
    {
        return commentService.removeComment(messageId, commentId);
    }
}
