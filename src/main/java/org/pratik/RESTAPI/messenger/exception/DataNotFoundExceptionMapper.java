package org.pratik.RESTAPI.messenger.exception;

import org.pratik.RESTAPI.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errormessage=new ErrorMessage(ex.getMessage(),404,"https://en.wikipedia.org/wiki/HTTP_404");
		return Response.status(Status.NOT_FOUND)
				.entity(errormessage)
				.build();
	}

}
