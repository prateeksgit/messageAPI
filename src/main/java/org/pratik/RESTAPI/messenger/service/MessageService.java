package org.pratik.RESTAPI.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.pratik.RESTAPI.messenger.database.DatabaseClass;
import org.pratik.RESTAPI.messenger.exception.DataNotFoundException;
import org.pratik.RESTAPI.messenger.model.Message;

public class MessageService {
	
	private static long nextId = 3;
	private static Map<Long, Message> messages= DatabaseClass.getMessages();
	
	
	public MessageService() {
		if(messages.isEmpty()) {
		messages.put(1L,new Message(1,"Hello World","Pratik"));
		messages.put(2L,new Message(2,"Hello Worldd","Pratikk"));
		}
	}
	
	public List<Message> getAllmessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list=new ArrayList<Message>(messages.values());
		
		return list.subList(start, start+size);
	}
	
	
	public Message getMessage(long id) {
		Message message= messages.get(id);
		if(message==null) {
			throw new DataNotFoundException("Message with id "+id+" not found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(nextId++);
		messages.put(message.getId(), message);	
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(),message);
		System.out.println(messages);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
