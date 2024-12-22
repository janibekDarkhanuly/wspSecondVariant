package employee;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;

public class Employee extends User implements SendMesseges,Serializable {
	public Employee() {
		
	}
	
	public Employee(String iD, String password, String login, String name, String surname,
			Date birthDate, String email, Language language, Gender gender, int salary) {
		super(iD, password, login, name, surname, birthDate, email, language, gender, salary);
	}
    

    public String viewStudentsInfo() {
        return "";
    }
    

    public Vector<Course> viewCoursesOfStudent() {
        return null;
    }

    public String viewTeacherInfo() {
        return "";
    }
    
    public String sendOrder() {
        return "";
    }

	public void readMessege() {
		
	}

	public void sendMessege() {

		
	}

	public void sendComplain() {
		
	}
    
    
}
    
    

