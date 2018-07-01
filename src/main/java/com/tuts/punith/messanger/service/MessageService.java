package com.tuts.punith.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuts.punith.messanger.database.MessageDataBase;
import com.tuts.punith.messanger.model.Comment;
import com.tuts.punith.messanger.model.Message;

public class MessageService
{
    Map<Long, Message> messages = MessageDataBase.getMessages();
    Map<Long, Comment> comments = new HashMap<>();

    public MessageService()
    {
        messages.put(1L, new Message(1, "Hi there!", "Punith", new Date()));
        messages.put(2L, new Message(2, "Hi! how are you?", "Punith", new Date()));

        Comment comment1 = new Comment(1, "Good morning!", "Punith", new Date());
        Comment comment2 = new Comment(2, "How is life!!", "Sahana", new Date());

        comments.put(1L, comment1);
        comments.put(2L, comment2);

        messages.get(1L).setComments(comments);
        messages.get(2L).setComments(comments);
    }

    public List<Message> getMessages()
    {
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year)
    {
        List<Message> messagesForYear = new ArrayList<Message>();
        Calendar cal = Calendar.getInstance();

        for (Message message : messages.values())
        {
            cal.setTime(message.getCreateDate());

            if (cal.get(Calendar.YEAR) == year)
            {
                messagesForYear.add(message);
            }
        }

        return messagesForYear;
    }

    public List<Message> getMessagesPaginated(int start, int size)
    {
        List<Message> list = new ArrayList<Message>(messages.values());

        if (start + size > list.size())
        {
            return new ArrayList<Message>();
        }

        return list.subList(start, start + size);
    }

    public Message getMessage(long id)
    {
        return messages.get(id);
    }

    public Message addMessage(Message message)
    {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);

        return message;
    }

    public Message updateMessage(Message message)
    {
        if (message.getId() <= 0)
        {
            return null;
        }

        messages.put(message.getId(), message);

        return message;
    }

    public Message removeMessage(long id)
    {
        return messages.remove(id);
    }
}
