package communication;

import java.util.Vector;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.Date;

import employee.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;
import enums.*;


public class Messenger {
	private Vector<Chat> chats;
	private User owner;
	
	public Messenger(User owner) {
		this.chats = new Vector<Chat>();
		this.owner = owner;
		
	}
	
	public void showChats() {
		for(Chat chat:chats) {
			System.out.println(chat);
		}
	}
	
	public void sendMessageTo(String name, Message message) {
		for(Chat chat:chats) {
			if(chat.getName() == name) {
				chat.sendMessage(message);
			}
		}
	}
	
	public void createChat(User other, String name) {
		if(chats.add(new Chat(other, name, this.owner))) {
			chats.lastElement().add(owner);
			other.getMyMessenger().addChat(chats.lastElement());
			System.out.println(other.getMyMessenger().getChats());
		};
	}
	
	public void addChat(Chat chat) {
		chats.add(chat);
	}
	public void deleteChat(Chat chat) {
		chats.remove(chat);
	}
	
	public void addUserTo(String name, User other) {
		for(Chat chat:chats) {
			if(chat.getName() == name) {
				chat.add(other);
			}
		}
	}
	
	public void deleteUserTo(String name, User other) {

		for(Chat chat:chats) {
			if(chat.getName() == name) {
				if(owner == other) {
					System.out.println();
					return;
				}
				if(chat.delete(other)) {
					other.getMyMessenger().deleteChat(chat);
					System.out.println("DELETED");
				}
				else {
					System.out.println("There was not that person");
				}
			}
		}
	}
	public void showChat(String name) {

		for(Chat chat:chats) {
			if(chat.getName() == name) {
				System.out.println("\t\t" + chat.getName());
				chat.showMessages();
				return;
			}
		}
		System.out.println("There is not chat with that name");
	}
	
	public Vector<Chat> getChats() {
		return chats;
	}
}
