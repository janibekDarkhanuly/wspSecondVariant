package student;
import java.util.Vector;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;

import employee.*;
import enums.GradStudents;
import researcher.*;
import student.*;
import system.*;



public class Transcript implements Serializable{
    private Map<Course,Mark> marks = new HashMap<>();
    private Student student;
                                 
    public void addCourse(Course c) {
    	marks.put(c,new Mark(0));
    }
	
	
	public Map<Course, Mark> getMarks() {
		return marks;
	}
	
	public void addMarks(Course c,double mark) {
		if (marks.containsKey(c)) {
            Mark originalValue = marks.get(c); // Get the original value
            originalValue.addMark(mark);
            marks.put(c,originalValue); // Put the updated value back in the map
            System.out.println("Updated value for key '" + c + "': " + originalValue.getMark());
        } else {
            System.out.println("Key '" + c + "' not found in the map.");
        }		
	}
	


	public void setMarks(Map<Course, Mark> marks) {
		this.marks = marks;
	}




	public void downloadTranscript() {
	        // Check if there are marks to generate a transcript
	     if (marks != null && !marks.isEmpty()) {
	            // TODO: Implement logic to generate/download the transcript file
	            System.out.println("Transcript downloaded successfully!");
	      } else {
	            System.out.println("No marks available. Transcript not generated.");
	        }
	    }
	
	
    

    public void seeTranscript() {
    	for (Entry<Course, Mark> entry : marks.entrySet()) {
            Course key = entry.getKey();
            Mark value = entry.getValue();
            System.out.println("course: " + key.getNameOfCourse() + ", Value: " + value.getMark());
        }
        return;
    }
    
    
    
}
