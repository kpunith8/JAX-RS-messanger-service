package com.tuts.punith.messanger.exception;

public class DataNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 7616351710671870884L;

    public DataNotFoundException(String message)
    {
        super(message);
    }
}
