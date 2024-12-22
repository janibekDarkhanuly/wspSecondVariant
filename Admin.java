package system;
import java.util.Vector;

import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import employee.*;
import student.*;
import researcher.*;
import enums.*;

public class Admin extends User implements Serializable {
	public Admin() {
		
	}
	public Admin(String login,String password) {
		super(login,password);
	}
	public void deleteUser(String login) {
        DataBase database = DataBase.getInstance();
        database.deleteUser(login);
	}
	public void run() throws IOException, NumberFormatException, ParseException {
		System.out.println("Welcome!");
		 while(true){
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader bReader=new BufferedReader(isr);
				System.out.println("What do you want to do?\n 1)see All Users \n 2) see Log  \n 3) delete User  \n 4) add User \n 5) Exit");
				int choice = Integer.parseInt(bReader.readLine());
				if(choice==1){
					seeAllUsers();
				}
				else if (choice==2){
					seeLog();
				}
				else if (choice==3){
					System.out.println("what is the login:");
					String loginToDelete=bReader.readLine();
					deleteUser(loginToDelete);
				}
				else if (choice==4){
					System.out.println("Login to add:");
					String loginToAdd=bReader.readLine();
					System.out.println("password to add:");
					String passwordToAdd=bReader.readLine();
					addUser(loginToAdd, passwordToAdd);
				}
				else if (choice==5){
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
	public void seeLog() {
        DataBase database = DataBase.getInstance();
        Map<User, String> logs = database.getLogs();	
        System.out.println("Logs:");
        for (Map.Entry<User, String> entry : logs.entrySet()) {
            User user = entry.getKey();
            String log = entry.getValue();
            System.out.println("User: " + user.getName() + " - Log: " + log);
        }
    }
	public void addUser(String username,String password) throws NumberFormatException, IOException, ParseException {
		System.out.println("1-admin\n2-manager\n3-teacher\n4-Student\n5-researcher");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		int choice=Integer.parseInt(bReader.readLine());
		User u;
		if(choice==1) {
			u=new Admin(username,password);
		}else{
			System.out.println("name:");
			String name=bReader.readLine();

			System.out.println("surename:");
			String surname=bReader.readLine();

			System.out.println("ID:");
		    String ID=bReader.readLine();

			System.out.println("birhdate(dd-mm-yyyy):");
			SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-yyyy");
			Date birthDate=sdf.parse(bReader.readLine());

			System.out.println("email:");
		    String email=bReader.readLine();

			System.out.println("salary or shcoolarship:");
		    int salary=Integer.parseInt(bReader.readLine());

		    System.out.println("Gender:1-male\n2-female");
		    int choiceGender=Integer.parseInt(bReader.readLine());
		    Gender gender;
		    if(choiceGender==1){
		    	gender=Gender.Male;
		    }else{
		        gender=Gender.Female;
		    }

		    System.out.println("Language:1-English\n2-Russian\n3-Kazakh");
		    int choiceLang=Integer.parseInt(bReader.readLine());
		    Language language;
		    if(choiceLang==1){
		    	language=Language.En;
		    }else if(choiceLang==2){
		    	language=Language.Ru;
		    }else{
		    	language=Language.Kz;
		    }

			if(choice==2){
				System.out.println("1-OR\n2-Rector\n3-Dean");
		    	int choiceManangers=Integer.parseInt(bReader.readLine());
		    	Manangers manangers;
		    	if(choiceManangers==1){
			    	manangers=Manangers.OR;
		    	}else if(choiceManangers==2){
			    	manangers=Manangers.Reator;
		    	}else{
			    	manangers=Manangers.Dean;
		    	}
		    	u=new Manager(ID, password,username,name,surname,birthDate,email,language,gender,salary,manangers);
			}
			else if(choice==3){
				System.out.println("Your title:1-Proffsor\n2-Lector\n3-Tutor\n4-SeniorLector\n5-Assistant");
		    	int choiceTeachers=Integer.parseInt(bReader.readLine());
		    	TeacherTitle title;
		    	if(choiceTeachers==1){
		    		title=TeacherTitle.Proffsor;
		    	}else if(choiceTeachers==2){
		    		title=TeacherTitle.Lector;
		    	}else if(choiceTeachers==3){
		    		title=TeacherTitle.Tutor;
		    	}else if(choiceTeachers==4){
		    		title=TeacherTitle.SeniorLector;
		    	}else{
		    		title=TeacherTitle.Assistant;
		    	}
		    	u=new Teacher(ID, password, username, name, surname, birthDate, email, language, gender, salary, title);
			}else if(choice==4){
				System.out.println("your studyYear:");
		    	int studyYear=Integer.parseInt(bReader.readLine());

				System.out.println("school:1-BS\n2-SITE\n3-OGS\n4-ICE\n5-KMA\n6-MCM");
		    	int choiceSchool=Integer.parseInt(bReader.readLine());
		    	Schools schools;
		    	if(choiceSchool==1){
		    		schools=Schools.BS;
		    	}else if(choiceSchool==2){
		    		schools=Schools.SITE;
		    	}else if(choiceSchool==3){
		    		schools=Schools.OGS;
		    	}else if(choiceSchool==4){
		    		schools=Schools.ICE;
		    	}else if(choiceSchool==5){
		    		schools=Schools.KMA;
		    	}else{
		    		schools=Schools.MCM;
		    	}

				u=new Student(ID, password,username, name, surname, birthDate, email, language, gender, salary, studyYear, schools);
			}
			else{
				System.out.println("hIndex is:");
		    	int hIndex=Integer.parseInt(bReader.readLine());
		    	u=new Researcher(ID, password, username, name, surname, birthDate, email, language, gender, salary, hIndex);
			}
		}

        DataBase database = DataBase.getInstance();
        if(database.getRegisteredUsers().containsKey(username)) {
        	System.out.println("username alredy exists");
        }
        else {
        	database.registerUser(u);
        }
	}
    public void seeAllUsers(){
        DataBase database = DataBase.getInstance();
        Vector<User> users=database.getUsers();
        for(User u:users){
        	if(u instanceof Admin){
        		Admin newu=(Admin) u;
        		System.out.println(newu.toString());
        	}else if(u instanceof Manager){
        		Manager newu=(Manager) u;
        		System.out.println(newu.toString());
        	}else if(u instanceof Teacher){
        		Teacher newu=(Teacher) u;
        		System.out.println(newu.toString());
        	}else if(u instanceof Student){
        		Student newu=(Student) u;
        		System.out.println(newu.toString());
        	}else if(u instanceof Researcher){
        		Researcher newu=(Researcher) u;
        		System.out.println(newu.toString());
        	}
        }
    }
    
}
