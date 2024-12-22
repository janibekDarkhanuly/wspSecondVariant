package system;
import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.io.Serializable;
import java.util.Date;

import employee.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;
import enums.*;

public class Time  implements Serializable{
	public int hour;
	public int minute;
	public int second;
	public String Standartization="AM";

	
	public Time(int hour,int minute,int second){
		if((hour>0 && hour<=24) && (minute>0 && minute<60) && (second>0 && second<60)) {
			this.hour=hour;
			this.minute=minute;
			this.second=second;
		}else {
			System.out.println("Error");
		}
	}
	
	public String Universal() {
		return String.format("%d",this.hour)  + ':' + String.format("%d",this.minute) +':' + String.format("%d",this.second);
	}
	
	public String Standard() {
		int Standarted_hour=hour;
		if(Standarted_hour>=12) {
			Standarted_hour-=12;
			this.Standartization="PM";
		}else {
			this.Standartization="AM";

		}
		return String.format("%d",Standarted_hour)  + ':' + String.format("%d",this.minute) +':' + String.format("%d",this.second) + ' ' + this.Standartization;
	}
	public void add(Time t2) { 
		if(this.hour+t2.hour>24) {
			this.hour-=24;
		}if(this.minute+t2.minute>59) {
			this.minute-=60;
			this.hour+=1;
		}if(this.second+t2.second>59) {
			this.second-=60;
			this.minute+=1;
		}
		this.hour+=t2.hour;
		this.minute+=t2.minute;
		this.second+=t2.second;
	}
	public static void add(Time t1,Time t2) {
		if(t1.hour+t2.hour>24) {
			t1.hour-=24;
		}if(t1.minute+t2.minute>59) {
			t1.minute-=60;
			t1.hour+=1;
		}if(t1.second+t2.second>59) {
			t1.second-=60;
			t1.minute+=1;
		}
		t1.hour+=t2.hour;
		t1.minute+=t2.minute;
		t1.second+=t2.second;
	}
	
	
	
}
