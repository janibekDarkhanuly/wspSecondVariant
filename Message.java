package employee;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;

public class Message implements Serializable {

    private String title;
    private EmergencyLevel importanceLevel;
    private String messege;
    private LocalDate date;
    
    
    
	public Message(String title, EmergencyLevel importanceLevel, String messege) {
		this.title = title;
		this.importanceLevel = importanceLevel;
		this.messege = messege;
		this.date =LocalDate.now();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public EmergencyLevel getImportanceLevel() {
		return importanceLevel;
	}
	public void setImportanceLevel(EmergencyLevel importanceLevel) {
		this.importanceLevel = importanceLevel;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
    
	
   
}
