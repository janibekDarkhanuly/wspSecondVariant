package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import employee.*;
import system.*;
import student.*;
import researcher.*;

public class TestClass {
	public static void main(String[] args) throws Exception {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		Admin admin=new Admin();
		admin.run();
		User user=null;
		while(user==null) {
	        DataBase database = DataBase.getInstance();
	        
			System.out.println("Enter login:");
			String login=bReader.readLine();
			
			System.out.println("Enter Password:");
			String password=bReader.readLine();
			
			user=database.checkPassword(login, password);

		}
        	if(user instanceof Admin){
        		Admin newu=(Admin) user;
        		newu.run();
        	}else if(user instanceof Manager){
        		Manager newu=(Manager) user;
        		newu.run();
        	}else if(user instanceof Teacher){
        		Teacher newu=(Teacher) user;
        		newu.run();
        	}else if(user instanceof Student){
        		Student newu=(Student) user;
        		newu.run();
        	}else if(user instanceof Researcher){
        		Researcher newu=(Researcher) user;
        		newu.run();
        	}
       }

}
