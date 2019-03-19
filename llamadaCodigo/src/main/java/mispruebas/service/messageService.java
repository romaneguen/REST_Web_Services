package mispruebas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mispruebas.database.DatabaseClass;
import mispruebas.model.Message;

public class messageService {

	 private Map<Long, Message> messages = DatabaseClass.getMessages();
	 
	 public messageService() {
		 messages.put(1L, new Message(1L,"hello World", "koushik"));
		 messages.put(2L, new Message(2L,"hello jersey", "koushik"));
	 }
	 
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <=0) {
		return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(Long Id) {				
		return messages.remove(Id);
	}
}
