package student;
import java.util.Vector;



import java.util.Map;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import employee.*;
import student.*;
import system.*;
import interfaces.*;
import researcher.*;
import enums.*;
import communication.*;
import communication.News;



public class Student extends User  implements Serializable {
    private Transcript transcript=new Transcript();
    private int studyYear;
    private Schools school;
	private ListStudOrganizations organization;


    public Student(String iD, String password, String login, String name, String surname,
			Date birthDate, String email, Language language, Gender gender, int salary,
			int studyYear,Schools school) {
		super(iD, password, login, name, surname, birthDate, email, language, gender, salary);
		this.studyYear=studyYear;
		this.school=school;
		
	}
    
    public Student() {
		// TODO Auto-generated constructor stub
	}
    public void addToTranscript(Course c) {
    	this.transcript.addCourse(c);
    }
	public Transcript getTranscript() {
        return this.transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public int getStudyYear() {
        return this.studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public Schools getSchool() {
        return this.school;
    }

    public void setSchool(Schools school) {
        this.school = school;
    }

    
    
    
    
    
    public void viewMyCourses() {
    	
    }


    
    public void run() throws IOException, NumberFormatException, ParseException {
		System.out.println("Welcome!");
		 while(true){
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader bReader=new BufferedReader(isr);
				System.out.println("What do you want to do?\n "
						+ "1)Info about student \n 2)Course  \n 3)Teacher  \n 4)View News \n 5)Transcript \n 6)Student Organizations \n 7)Exit");
				int choice=Integer.parseInt(bReader.readLine());
				if (choice == 1) {
					toString();
				}
				else if(choice == 2) {
					System.out.println("Choose what do you want \n 1)View Course \n2)Registraishion for Cousre");
					int course=Integer.parseInt(bReader.readLine());
					Course c = new Course();
					if (course == 1) {
					}
					else if (course == 2) {
						c.viewAllCourse();
					}
				}
				else if(choice == 3) {
					System.out.println(" 1)Info about Teachers \n 2)Rate Teachers");
					int teacher=Integer.parseInt(bReader.readLine());
					if (teacher == 1) {
						DataBase database = DataBase.getInstance();
				        Vector<User> users=database.getUsers();
				        for(User ur:users){
				        	if(ur instanceof Teacher){
				        		Teacher newu=(Teacher) ur;
				        		System.out.println(newu.toString());
				        	}
				        }
					}
					else if (2 == teacher) {
						rateTeacher();
					}
				}
				else if(choice == 4) {
					News newsboard = new News();
					newsboard.showPublications();
				}
				else if(choice == 5) {
					System.out.println("Your transcript");
					this.transcript.seeTranscript();
				}
				else if(choice == 6) {
					User u = new User();
					StudOrganizations so = new StudOrganizations();
					Vector <User> members = new Vector<User>();
					boolean t = true;
					while(t) {
						if(members.contains(u)) {
							System.out.println("Yes");
							t = false;
						}
					}
					if
					(t == false) {
						
					}
					
				}
				else if(choice == 7) {
					
				}
				else if(choice == 8) {
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
    
    

    public int rateTeacher() {
    	int count = 5;
    	Scanner scanner = new Scanner(System.in);
    	int sum = 0;
    	while(count > 1){
    	if(count == 5){
    	System.out.println("от 1 до 10 какой у него уровень знаний по дисциплине");
    	int q5 = scanner.nextInt();
    		if(isValidRating(q5)) {
    			sum += q5;
    		}
    		else {
    			System.out.println("Оценка должна быть в диап 1 - 10");
    		}
    	}
    	if(count == 4){
    	System.out.println("от 1 до 10 честность оценивания преподавателя");
    	int q4 = scanner.nextInt();
    		if(isValidRating(q4)) {
    			sum += q4;
    		}
    		else {
    			System.out.println("Оценка должна быть в диап 1 - 10");
    		}
    	}
    	if(count == 3){
    	System.out.println("от 1 до 10 вовлеченность. в урок");
    	int q3 = scanner.nextInt();
    		if(isValidRating(q3)) {
    			sum += q3;
    		}
    		else {
    			System.out.println("Оценка должна быть в диап 1 - 10");
    		}
    	}
    	if(count == 2){
    	System.out.println("от 1 до 10 регулярность проверки присутствия");
    	int q2 = scanner.nextInt();
    		if(isValidRating(q2)) {
    			sum += q2;
    		}
    		else {
    			System.out.println("Оценка должна быть в диап 1 - 10");
    		}
    	}
    	if(count == 1){
    	System.out.println("от 1 до 10 аполитичность и толерантность");
    	int q1 = scanner.nextInt();
    		if(isValidRating(q1)) {
    			sum += q1;
    		}
    		else {
    			System.out.println("Оценка должна быть в диап 1 - 10");
    		}
    	}
    	count -= 1;
    	}

        // TODO: Implement logic to rate the teacher
        return sum/5;
    }
    
    private boolean isValidRating(int rating) {
        return rating >= 1 && rating <= 10;
    }
    public boolean isInOrganization() {
        return organization != null;
    }


    public void checkAndPrintOrganizationStatus() {
        if (isInOrganization()) {
            System.out.println(this.getName() + " состоит в организации: " + organization.name());
        } else {
            System.out.println(getName() + ", у вас есть отличная возможность вступить в одну из организаций:");
            for (ListStudOrganizations org : ListStudOrganizations.values()) {
                System.out.println("- " + org.name());
            }
        }
    }
    public void changeMark(Course c,int mark) {
    	this.transcript.addMarks(c, mark);
    }
	@Override
	public String toString() {
		return super.toString()+"\nStudent [transcript=" + transcript + ", studyYear=" + studyYear + ", school=" + school + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(school, studyYear, transcript);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return school == other.school && studyYear == other.studyYear && Objects.equals(transcript, other.transcript);
	}
    
    
}
