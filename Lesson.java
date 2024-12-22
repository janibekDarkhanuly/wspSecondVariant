package employee;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;

public class Lesson {
    private String title;
    private LessonType lessonType;
    private String description;
    private Teacher teacher;
   
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
	

	public String startLesson() {
        return "";
    }
    
    public String endLesson() {
        return "";
    }

    public List<String> uploadLessonMaterial() {
        return null;
    }
    
    public void conductPracticeSession() {
   
        return;
    }
    
    
}
