package student;
import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.io.Serializable;
import java.util.HashMap;

import employee.*;
import enums.GradStudents;
import researcher.*;
import student.*;
import system.*;




public class Mark implements Serializable{
    private double mark;



	public Mark(double mark) {
		this.mark = mark;
	}

	public double getMark() {
		return mark;
	}
	public void addMark(double mark) {
		this.mark+=mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}

	public String getLetter() {
        return "";
    }
    
    
}
