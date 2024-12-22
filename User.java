package system;
import java.util.Vector;
import java.util.concurrent.Flow.Subscriber;

import communication.Messenger;

import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.awt.geom.IllegalPathStateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Date;

import employee.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;
import enums.*;



public class User implements Serializable {
    private String login;
    private String password;
    private String ID;
    private String name;
    private String surname;
    private Vector<Message> messageLog =new Vector<Message>();
    private Date birthDate;
    private String email;
    private Language language;
    private  Gender gender;
    private int salary;
 
    
    public User() {
    	
    }    
    public User(String login,String password) {
    	this.login=login;
    	this.password=password;
    	
    }
    public User(String iD, String password, String login, String name, String surname,
			Date birthDate, String email, Language language, Gender gender, int salary) {
		super();
		this.ID=iD;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.email = email;
		this.language = language;
		this.gender = gender;
		this.salary = salary;
	}


	String getLogin() {
        return this.login;
    }
    

    protected void setLogin(String login) {
        this.login = login;
    }
    

    String getPassword() {
        return this.password;
    }

    protected void setPassword(String password) {
        this.password = password;
    } 
    

    public String getID() {
        return this.ID;
    }
    
    private void setID(String ID) {
        this.ID = ID;
    }
    

    public String getName() {
        return this.name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getSurname() {
        return this.surname;
    }
   
    public void setSurname(String surname) {
        this.surname = surname;
    }
    

    public  Vector<Message> getMessageLog() {
        return this.messageLog;
    }
    

    public void setMessageLog(Vector<Message> messageLog) {
        this.messageLog = messageLog;
    }
    

    public  Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public  String getEmail() {
        return this.email;
    }
    
  
    public void setEmail(String email) {
        this.email = email;
    }
    
 
    public Language getLanguage() {
        return this.language;
    }
   
    public void setLanguage(Language language) {
        this.language = language;
    }
    
 
    public  Gender getGender() {
        return this.gender;
    }
  
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
    
    
    

    //                          Operations                                  
    public void  SubscribeToJournal() {
    	DataBase.getInstance().subscribeToJournalPapper(this);
    }

    public LanguageCollection chooseLanguage() {
        return null;
    }

    public String login() {

        return "";
    }
    
    public boolean subscribeToJournal() {

        return false;
    }
    
    private void viewNews() {
        return ;
    }
    

    public boolean equals() {
    	return false;
    }
    
  
    public boolean getSalary() {
        //TODO
        return false;
    }
    public void takeMessages(Message m) {
    	this.messageLog.add(m);
    }
    public void sendOrderToTechSupport() throws IOException {
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		DataBase dataBase=DataBase.getInstance();
		int id=dataBase.getOrders().size()+1;
		System.out.println("description of your order:");
		String description=bReader.readLine();
		dataBase.addOrder(new Order(id, description,this.getID()));
    }
	@Override
	public int hashCode() {
		return Objects.hash(ID, birthDate, email, gender, language, login, messageLog, name, password, salary, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ID, other.ID) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(email, other.email) && gender == other.gender && language == other.language
				&& Objects.equals(login, other.login) && Objects.equals(messageLog, other.messageLog)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& salary == other.salary && Objects.equals(surname, other.surname);
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", ID=" + ID + ", name=" + name + ", surname="
				+ surname + ", messageLog=" + messageLog + ", birthDate=" + birthDate + ", email=" + email
				+ ", language=" + language + ", gender=" + gender + ", salary=" + salary + "]";
	}
	public Messenger getMyMessenger() {
		
		return null;
	}
}
