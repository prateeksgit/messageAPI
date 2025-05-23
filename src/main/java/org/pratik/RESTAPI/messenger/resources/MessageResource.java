package org.pratik.RESTAPI.messenger.resources;

import java.net.URI;
import java.util.List;

import org.pratik.RESTAPI.messenger.model.Message;
import org.pratik.RESTAPI.messenger.resources.beans.MessageFilterBean;
import org.pratik.RESTAPI.messenger.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/messages")
public class MessageResource {
	
	
	MessageService messageServivce= new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterbean) {
		
		if(filterbean.getYear()>0) {
			return messageServivce.getAllMessagesForYear(filterbean.getYear());
		}
		
		if(filterbean.getStart()>=0&& filterbean.getSize()>0) {
			return messageServivce.getAllMessagesPaginated(filterbean.getStart(),filterbean.getSize());
		}
		return messageServivce.getAllmessages();
	}
	//When a resource is created via POST, the server should respond with 
	//201 Created and a Location header pointing to the new resource.
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message,@Context UriInfo uriInfo) {
		Message newMessage=messageServivce.addMessage(message);
		String newId=String.valueOf(newMessage.getId());
		URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId")long id,Message message) {
		message.setId(id);
		return messageServivce.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")long id,Message message) {
		messageServivce.removeMessage(id);
	}
	

	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id) {
		return messageServivce.getMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentresource() {
		return new CommentResource();
	}
	
	
}
