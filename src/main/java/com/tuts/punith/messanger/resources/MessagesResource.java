package com.tuts.punith.messanger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.tuts.punith.messanger.exception.DataNotFoundException;
import com.tuts.punith.messanger.model.Message;
import com.tuts.punith.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessagesResource
{
    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
            @QueryParam("size") int size)
    {
        if (year > 0)
        {
            return messageService.getAllMessagesForYear(year);
        }

        if (start >= 0 && size >= 0)
        {
            return messageService.getMessagesPaginated(start, size);
        }

        return messageService.getMessages();
    }

    // Response object should be returned to add status, location other info instead of returning only the Message being
    // added.
    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException
    {
        Message newMessage = messageService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();

        // use created(URI) method to send created status and the location of the URI, or use status(Status.CREATED) if
        // you don't want location info

        return Response.created(uri)
                .entity(messageService.addMessage(message)).build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message)
    {
        message.setId(messageId);

        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long messageId)
    {
        return messageService.removeMessage(messageId);
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        Message message = messageService.getMessage(messageId);

        if (message == null)
        {
            throw new DataNotFoundException("Message with id " + messageId + " not found!");
        }

        return messageService.getMessage(messageId);
    }

    // Sub Resources
    @Path("/{messageId}/comments")
    public CommentResource getCommentResource()
    {
        return new CommentResource();
    }
}
