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


public class Chat {
	private Vector<User> members = new Vector<User>();
	private Vector<Message> messages = new Vector<Message>();
	private String name;
	public Chat(User other, String name) {
		this.members.add(other);
		this.name = name;
	}
	
	
	public Chat(User other, String name2, User owner) {
		this.members.add(other);
		this.name = name;
		
	}


	public void sendMessage(Message message) {
		messages.add(message);
	}
	
	public void showMessages() {
		for(Message message: messages) {
			System.out.println(message);
		}
	}
	
	public boolean add(User other) {
		if(members.contains(other)) {
			System.out.println("Он уже в чате");
			return false;
		}
		
		System.out.println("Start");
		members.add(other);
		return true;
	}
	
	public boolean delete(User other) {
		return members.remove(other);
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name + "\n" + members;
	}
}
