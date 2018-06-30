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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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

    @POST
    public Message addMessage(Message message)
    {
        return messageService.addMessage(message);
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
        return messageService.getMessage(messageId);
    }
}
