package system;
import java.util.Vector;
import java.util.stream.Collectors;


import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import employee.*;
import enums.OrderStatus;
import researcher.*;
import student.*;

public class DataBase implements Serializable{
    private static DataBase instance;
    private Vector   <User>             users= new Vector<User>();
    private Map      <User,String>      logs=new HashMap<User,String>();
    private Vector   <News>             newsPaper=new Vector<News>(); 
    private Vector   <ResearchProject>  projects=new Vector<ResearchProject>();
    private HashMap  <String, User>     registeredUsers = new HashMap<>();
    private Vector   <Order>            orders=new Vector<Order>();
    private Map      <User,String>      messages=new HashMap<User,String>();
    private Vector   <Course>           courses=new Vector<Course>();
    private List     <String>           documents=new ArrayList<String>();
    private Journal                     journal=new Journal("Kbtu Journal");
    private HashMap  <User, Course>     registeredCourse = new HashMap<>();

	static {
		if(new File("database.txt").exists()) {
			try {
				instance = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else instance = new DataBase();
	}
    private DataBase(){    	
    }
    
    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
    public void changeStudent(String idStudent,Course c) throws IOException {
    	for(User u:getUsers()) {
			if(u instanceof Student) {
				if(((Student)u).getID().equals(idStudent)) {
					((Student)u).addToTranscript(c);;
					write();
				}
			}
		}
    }
    public void changeStudentMark(String idStudent,Course c,int mark) throws IOException {
    	for(User u:getUsers()) {
			if(u instanceof Student) {
				if(((Student)u).getID().equals(idStudent)) {
					((Student)u).changeMark(c, mark);
					write();
				}
			}
		}
    }
	public static DataBase read() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("database.txt");
		ObjectInputStream oin = new ObjectInputStream(fis);
		return (DataBase) oin.readObject();
	}
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("database.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(instance);
		oos.close();
	}
    public Vector<User> getUsers() {
		return users;
	}
    public void updateTeacher(String IdTeacher,Course c) throws IOException {
    	for(User u:getUsers()) {
			if(u instanceof Teacher) {
				if(((Teacher)u).getID().equals(IdTeacher)) {
					((Teacher)u).setCourse(c);
					write();
				}
			}
		}
    }
	public Vector<News> getNewsPaper() {
		return newsPaper;
	}

	public void setNewsPaper(Vector<News> newsPaper) {
		this.newsPaper = newsPaper;
	}

	public HashMap<String, User> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(HashMap<String, User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public void setUsers(Vector<User> users) {
		this.users = users;
	}

	public Map<User, String> getLogs() {
		return logs;
	}

	public void setLogs(Map<User, String> logs) {
		this.logs = logs;
	}

	public Vector<ResearchProject> getProjects() {
		return projects;
	}

	public void setProjects(Vector<ResearchProject> projects) {
		this.projects = projects;
	}

	public Vector<Order> getOrders() {
		return orders;
	}

	public void setOrders(Vector<Order> orders) {
		this.orders = orders;
	}

	public Map<User, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<User, String> messages) {
		this.messages = messages;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public void subscribeToJournalPapper(User u) {
		this.journal.addSubscribers(u);
	}
	/**
    * @generated
    */
    public Vector<User> showAllUser() {
    	users.stream().forEach(System.out::println);
                return null;
    }
    
    /**
    * @generated
    */
    public Vector<Student> showAllStudent() {
    	users.stream().filter(n->n instanceof Student).map(n->(Student) n).forEach(System.out::println);
        return null;
    }
    
    
    /**
    * @generated
    */
    public Vector<Teacher> showAllTeacher() {
    	users.stream().filter(n->n instanceof Teacher).map(n->(Teacher) n).forEach(System.out::println);
        return null;
    }
    
    /**
    * @generated
    */
    public Vector<Manager> showAllManager() {
      	users.stream().filter(n->n instanceof Manager).map(n->(Manager) n).forEach(System.out::println);

        return null;
    }
	public void changeOrderStatus(int orderId,OrderStatus status) {
        for (Order order : orders) {
            if (order.getOrderId()==orderId && order.getStatus()==OrderStatus.NEW) {
                order.setStatus(status);
                System.out.println("Order " + orderId + "status has been changed");
                return;
            }
        }
	}
	public void addNewsAboutTopCited() {
		List<Researcher> sortedReserchers = users.stream().
		filter(n->n instanceof Researcher).
		map(user -> (Researcher) user).
		sorted((a,b)->a.calculateHIndex()>b.calculateHIndex()?1:-1).
		limit(1).collect(Collectors.toList());
		newsPaper.add(new News("top cited of month is"+sortedReserchers.get(0).getName(),sortedReserchers.get(0).toString()));
	}
	public Teacher getTeacherById(String name) {
		for(User u:getUsers()) {
			if(u instanceof Teacher) {
				if(((Teacher)u).getID().equals(name)) {
					return (Teacher)u;
				}
			}
		}
		return null;
	}
	public Course takeCourse(String name) {
		for(Course course:courses) {
			if(course.getNameOfCourse().equals(name)) {
				return course;
			}
		}
		return null;
	}
	public void addCourse(Course c) throws IOException {
		this.courses.add(c);
		write();
	}
	public void deleteUser(String login) {
        if (users.contains(registeredUsers.get(login))) {
            users.remove(registeredUsers.get(login));
        }
        if (registeredUsers.containsKey(login)) {
        	registeredUsers.remove(login);
        }  
	}
	public void addOrder(Order o) {
		this.orders.add(o);
	}
	public void addResearchProject(ResearchProject rp) {
		this.projects.add(rp);
	}
	public void addNews(News news) {
		this.newsPaper.add(news);
	}
	public User checkPassword(String login,String password) {
        // Simulating password check (Replace with secure password hashing in real implementation)
        if (registeredUsers.containsKey(login)) {
            String storedPassword = registeredUsers.get(login).getPassword();
            if(storedPassword.equals(password)) {
            	return registeredUsers.get(login);
            }else {
            	System.out.println("Try again,wrong password:");
            	return null;
            }
        }
    	System.out.println("No such login:");
        return null;
    }
	@Override
	public int hashCode() {
		return Objects.hash(logs, orders, projects, users);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataBase other = (DataBase) obj;
		return Objects.equals(logs, other.logs) && Objects.equals(orders, other.orders)
				&& Objects.equals(projects, other.projects) && Objects.equals(users, other.users);
	}
	@Override
	public String toString() {
		return "DataBase [users=" + users + ", logs=" + logs + ", projects=" + projects + ", orders=" + orders + "]";
	}
	
	public void registerUser(User u) throws IOException { 
            // Simulating password hashing (Replace with proper hashing algorithm in real implementation) 
            registeredUsers.put(u.getLogin(),u); 
            users.addElement(u);
            System.out.println("Registration successful for user: " + u.getLogin()); 
            write();

    }

	public HashMap<User, Course> getRegisteredCourse() {
		return registeredCourse;
	}

	public void setRegisteredCourse(HashMap<User, Course> registeredCourse) {
		this.registeredCourse = registeredCourse;
	}
}

    

        