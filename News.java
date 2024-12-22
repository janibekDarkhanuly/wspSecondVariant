package system;
import java.util.Vector;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import employee.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;
import enums.*;


public class News  implements Serializable{
    private String topic;
    
    private Map<User,String> comments;
    
    private String message;
    
	public News() {
		
	}
    public News(String topic, String message) {
		this.topic = topic;
		this.message = message;
	}
    public String getMessages() {
        return this.message;
    }
    
    public void setMessages(String messages) {
        this.message = messages;
    }
    
    
 

    public String getTopic() {
        return this.topic;
    }
    
  
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public Map<User,String> getComments() {
        return this.comments;
    }
    public void setComments(Map<User,String> comments) {
        this.comments = comments;
    }
    
    public void removeComment(User u) {
    	comments.remove(u);
    }
    public void autoTopCitedResercher() {
        DataBase database = DataBase.getInstance();
        database.addNewsAboutTopCited();
    }
	@Override
	public int hashCode() {
		return Objects.hash(comments, message, topic);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(comments, other.comments)
				&& Objects.equals(message, other.message) && Objects.equals(topic, other.topic);
	}
	@Override
	public String toString() {
		return "News [topic=" + topic +  ", comments=" + comments + ", message=" + message + "]";
	}
    

    
    
}
