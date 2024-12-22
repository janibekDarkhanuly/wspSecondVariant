package researcher;

import java.util.Vector;

import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;
public class Journal  implements Serializable{
    private String                   name;
    private Vector<User>             subscribers= new Vector<User>();
    
    public Journal() {
	}
	public Journal(String name) {
		this.name = name;
	}
	public void notifyUsers(ResearchPaper newPaper) {
        for (User user : subscribers) {
            sendNotification(user, newPaper);
        }
    }
	public void printAllPappers() {
		getPappersFromResearchers().stream().forEach(System.out::println);
	}
    private void sendNotification(User user, ResearchPaper paper) {
    	Message message=new Message("new papper published!!!",EmergencyLevel.Low,"Researcher "+paper.getAuthors().elementAt(0).getName()+"-published new papper named"+paper.getName());
    	user.takeMessages(message);
        System.out.println("Уведомление отправлено пользователю " + user.getName() +
        ": Новая статья опубликована - " + paper.getName());
    }
    public Vector<ResearchPaper> getPappersFromResearchers(){
    	DataBase dataBase=DataBase.getInstance();
    	Vector<User> users=dataBase.getUsers();
    	Vector<ResearchPaper> papersVector=new Vector<ResearchPaper>();

    	for(User u:users) {
    		if(u instanceof Researcher) {
    			papersVector.addAll(((Researcher) u).getPapers());
    		}
    	}
		return papersVector;
    }
    public void printTopCited() {
    	
        getPappersFromResearchers().sort(Comparator.comparingInt(ResearchPaper::getCitations).reversed());
        for (int i = 0; i < Math.min(10,getPappersFromResearchers().size()); i++) {
            System.out.println((i + 1) + ". " + getPappersFromResearchers().get(i).getName());
        }
    }
    
    private Vector<User> getSubscribers() {
        return this.subscribers;
    }
    
    private void setSubscribers(Vector<User> subscribers) {
        this.subscribers = subscribers;
    }
    public void addSubscribers(User u) {
    	subscribers.add(u);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "subscribers=" + subscribers +
                ", researchPapers=" + getPappersFromResearchers() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        Journal journal = (Journal) o;
        return subscribers.equals(journal.subscribers) &&
        		getPappersFromResearchers().equals(journal.getPappersFromResearchers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribers, getPappersFromResearchers());
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

    
