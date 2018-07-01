package com.tuts.punith.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.tuts.punith.messanger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{
    @Override
    public Response toResponse(DataNotFoundException dataNotFoundException)
    {
        return Response.status(Status.NOT_FOUND)
                .entity(new ErrorMessage(404, dataNotFoundException.getMessage(), "Documentation URI to fix")).build();
    }
}
