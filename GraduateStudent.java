package student;
import java.util.Vector;

import communication.Message;

import java.util.Map;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import employee.*;
import enums.Gender;
import enums.GradStudents;
import enums.Language;
import enums.Schools;
import researcher.*;
import student.*;
import system.*;



public class GraduateStudent extends Student  implements Serializable{
   

	private GradStudents type;
    private Researcher supervisor;
    private Vector<ResearchPaper> diplomaProject;

    public GraduateStudent(String iD, String password, String login, String name, String surname,
			Date birthDate, String email, Language language, Gender gender, int salary,
			int studyYear,Schools school,GradStudents type) {
		super(iD, password, login, name, surname, birthDate, email, language, gender, salary,studyYear,school);
		this.type=type;
		
		
	}

    public GradStudents getType() {
        return this.type;
    }

    public void setType(GradStudents type) {
        this.type = type;
    }

    public Researcher getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
    }

    public Vector<ResearchPaper> getDiplomaProject() {
        return this.diplomaProject;
    }

    public void setDiplomaProject(Vector<ResearchPaper> diplomaProject) {
        this.diplomaProject = diplomaProject;
    }

	@Override
	public String toString() {
		return super.toString() +" GraduateStudent [type=" + type + ", supervisor=" + supervisor + "]";
	}
    
    
}

