package employee;


import java.util.Vector;

import communication.News;

import java.util.Map;
import java.util.Objects;
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
import student.*;
import system.*;
import interfaces.*;
import researcher.*;

public class Teacher extends Employee implements SendMesseges,Serializable {
    private Course course;
    private TeacherTitle title;
    private List<Lesson> lesson;
    
    public Teacher() {
    	
    }
    public Teacher(String iD, String password, String login, String name, String surname,Date birthDate, String email, Language language, Gender gender, int salary,TeacherTitle title) {
    	super(iD, password, login, name, surname, birthDate, email, language, gender, salary);
    	this.title=title;
    }
    

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public TeacherTitle getTitle() {
		return title;
	}

	public void setTitle(TeacherTitle title) {
		this.title = title;
	}

	public List<Lesson> getLesson() {
		return lesson;
	}

	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}
    private void putMark() {
        System.out.println("Mark is puted");
    }
    
    public void run() throws IOException, NumberFormatException, ParseException {
		System.out.println("Welcome!");
		 while(true){
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader bReader=new BufferedReader(isr);
				System.out.println("What do you want to do?\n "
						+ "1)Info about Teacher \n 2)Course  \n 3)Student \n 4)View News \n 5)Put Mark \n 6)Messeger \n 7)Exit");
				int choice=Integer.parseInt(bReader.readLine());
				if (choice == 1) {
					toString();
				}
				else if(choice == 2) {
					System.out.println("Choose what do you want \n 1)View Course \n2)Manage for Cousre");
					int course=Integer.parseInt(bReader.readLine());
					Course c = new Course();
					if (course == 1) {
					}
					else if (course == 2) {
						c.viewAllCourse();
					}
				}
				else if(choice == 3) {
					System.out.println(" 1)Info about Student");
					int teacher=Integer.parseInt(bReader.readLine());
					DataBase database = DataBase.getInstance();
			        Vector<User> users=database.getUsers();
			        for(User ur:users){
			        	if(ur instanceof Teacher){
			        		Teacher newu=(Teacher) ur;
			        		System.out.println(newu.toString());
			        	}
			        }
				}
				else if(choice == 4) {
					News newsboard = new News();
					newsboard.showPublications();
				}
				else if(choice == 5) {
					System.out.println("student id");
					String idStudent=bReader.readLine();
					System.out.println("Course name:");
					String courseName=bReader.readLine();
					Course course=DataBase.getInstance().takeCourse(courseName);
					System.out.println("add mark:");
					int mark=Integer.parseInt(bReader.readLine());
					DataBase.getInstance().changeStudentMark(idStudent,course,mark);
					

					System.out.println("Put Mark");
					
				}
				else if(choice == 6) {
					
					
				}
				else if(choice == 7) {
					System.out.println("Bye bye");
					try {
						DataBase.write();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		 }
    public void manageCourse() {
        return;
    }

    public void sendRequest() {
        return;
    }

    public String sendComplainAboutStudent() {
        return "";
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(course, lesson, title);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(course, other.course) && Objects.equals(lesson, other.lesson) && title == other.title;
	}
	@Override
	public String toString() {
		return  super.toString() +"\n Teacher [course=" + course + ", title=" + title + ", lesson=" + lesson + "]";
	}
}
    
