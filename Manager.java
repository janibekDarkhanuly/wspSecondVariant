
package employee;

import java.util.Vector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import enums.*;
import system.*;


public class Manager extends Employee {
     
    private Manangers type; 
    private Vector<Message> requests; 
     
     
 
    public Manager() {
    	
    }
    public Manager(String iD, String password, String login, String name, String surname, Date birthDate, String email, Language language, Gender gender, int salary, Manangers manangers) {
    	super(iD, password, login, name, surname, birthDate, email, language, gender, salary);
    	this.type=manangers;
    }


    public void addCourse() throws Exception {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		
		System.out.println("Name of Course:");
		String name = bReader.readLine();
		
		System.out.println("Credits: ");
		int credits = Integer.parseInt(bReader.readLine());
		
		System.out.println("Type of course: \n 1)Major \n 2)Minor \n 3) Free");
		int typeCourse = Integer.parseInt(bReader.readLine());
		TypeOfCourse type = null;
		if (typeCourse == 1) {
			type = TypeOfCourse.Major;
		}
		else if (typeCourse == 2) {
			type = TypeOfCourse.Minor;
		}
		else if (typeCourse == 3) {
			type = TypeOfCourse.Free;
		}
		
		System.out.println("Teacher: ");
		String teacher = bReader.readLine();

		Course c = new Course(name,credits, type,teacher);
		System.out.print("Course is added");
		
		DataBase database = DataBase.getInstance();
        if(database.getCourses().contains(c)) {
        	System.out.println("Course alredy exists");
        }
        else {
        	database.addCourse(c);
        }
    }
    public void manageRequests() { 
     for(Message r : requests){ 
    	 System.out.println(r.toString());
     } 
    } 

    public Boolean confirmRegistration(User s, Course c){ 
    	DataBase.getInstance().getRegisteredCourse().put(s, c);
		return null;
    } 
    public void manangeNews(News n) { 
    	DataBase dataBase=DataBase.getInstance();
        dataBase.addNews(n);
        
       } 

    public void viewInfoTeachers() { 
    	DataBase dataBase=DataBase.getInstance();
    	dataBase.showAllTeacher();
    }
    public void addCourseForRegistration(Course c) { 
    	DataBase dataBase=DataBase.getInstance();
    	dataBase.getCourses().add(c);
    } 

    public void viewInfoStudents() { 
    	DataBase dataBase=DataBase.getInstance();
    	dataBase.showAllStudent();
    } 



    public String toString() { 
        return super.toString() + " Manager Type: " + type; 
    } 
 

    public Manangers getType() { 
        return type; 
    } 

    public void setType(Manangers t) { 
     type = t; 
    } 
 
	public void run() throws Exception {
		System.out.println("Welcome!");
		 while(true){
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader bReader=new BufferedReader(isr);
				System.out.println("What do you want to do?\n 1)view info about students\n 2) view info about teachers  \n 3)see reguests \n 4) confirm regitration for student\n 5) assign course to teacher   \n 6) add course for registration  \n 7) Exit");
				int choice =Integer.parseInt( bReader.readLine());
				if(choice==1){
					viewInfoStudents();
				}
				else if (choice==2){
					viewInfoTeachers();
				}
				else if (choice==3){
					manageRequests();
				}
				else if (choice==4){
					System.out.println("student id");
					String idStudent=bReader.readLine();
					System.out.println("Course name:");
					String courseName=bReader.readLine();
					Course course=DataBase.getInstance().takeCourse(courseName);
					DataBase.getInstance().changeStudent(idStudent,course);
				}else if (choice==5){
					System.out.println("Teacher id:");
					String idTeacherString=bReader.readLine();
					Teacher teacher=DataBase.getInstance().getTeacherById(idTeacherString);
					System.out.println("Course name:");
					String courseName=bReader.readLine();
					Course course=DataBase.getInstance().takeCourse(courseName);
					System.out.print(DataBase.getInstance().getCourses().toString());
					if(teacher==null || course==null) {
						throw new Exception("no such course or teacher");
					}else {
						DataBase.getInstance().updateTeacher(idTeacherString, course);
					}
				}else if (choice==6){
					addCourse();
				}
				else if (choice==7){
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
 

    public Vector<Message> getRequests(){ 
    	return requests; 
    } 
}
