package org.pratik.RESTAPI.messenger.exception;

import org.pratik.RESTAPI.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errormessage=new ErrorMessage(ex.getMessage(),500,"https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errormessage)
				.build();
	}
	
	

}
