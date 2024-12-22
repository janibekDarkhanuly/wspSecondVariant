package employee;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;

public class Course implements Serializable{
    private String nameOfCourse;
    private int credits;
    private TypeOfCourse type;
    private String instructors;
    
    public Course(String name, int credits, TypeOfCourse type, String teacher) {
    	this.nameOfCourse = name;
		this.credits = credits;
		this.type = type;
		this.instructors = teacher;
    }
	public Course() {
	}

	
	public String getNameOfCourse() {
		return nameOfCourse;
	}

	public void setNameOfCourse(String nameOfCourse) {
		this.nameOfCourse = nameOfCourse;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public TypeOfCourse getType() {
		return type;
	}

	public void setType(TypeOfCourse type) {
		this.type = type;
	}



	

	public void viewAllCourse() {
		
	}
	
	
	public void addCourseToUser(Student u) throws NumberFormatException, IOException, ParseException{
		
	}
	
	
	public void registerToCourse(Student s) throws NumberFormatException, IOException, ParseException{
		viewAllCourse();
		System.out.println("Choose course and write name of course");
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		String name = bReader.readLine();
		addCourseToUser(s);
		
	}
	
	

	public String toString() {
		return "Course [nameOfCourse=" + nameOfCourse + ", credits=" + credits + ", type=" + type + ", instructors="
				+ instructors + "]";
	}
    
    
    
    
}
