package com.tuts.punith.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tuts.punith.messanger.database.MessageDataBase;
import com.tuts.punith.messanger.model.Comment;
import com.tuts.punith.messanger.model.Message;

public class CommentService
{
    private Map<Long, Message> messages = MessageDataBase.getMessages();

    public List<Comment> getAllComments(long messageId)
    {
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        return new ArrayList<Comment>(comments.values());
    }

    public Comment getCommentById(long messageId, long commentId)
    {
        // Consider using WebApplicationException instead of custom exception
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment)
    {
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);

        return comment;
    }

    public Comment updateComment(long messageId, Comment comment)
    {
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        if (comment.getId() <= 0)
        {
            return null;
        }

        comments.put(comment.getId(), comment);

        return comment;
    }

    public Comment removeComment(long messageId, long commentId)
    {
        Map<Long, Comment> comments = messages.get(messageId).getComments();

        return comments.remove(commentId);
    }
}
