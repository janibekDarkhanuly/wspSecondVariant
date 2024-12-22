package researcher;

import java.util.Vector;
import java.util.PrimitiveIterator.OfDouble;
import java.util.spi.AbstractResourceBundleProvider;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.text.AbstractDocument.BranchElement;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.awt.print.Paper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;





public class Researcher extends User  implements Serializable {
    private int hIndex;
    private Vector<ResearchPaper> Papers=new Vector<ResearchPaper>();
    public Researcher() {
    	
    }
    public Researcher(String iD, String password, String login, String name, String surname,
			Date birthDate, String email, Language language, Gender gender, int salary,int hIndex) {
    	super(iD, password, login, name, surname, birthDate, email, language, gender, salary);
    	this.hIndex=hIndex;
    }
    
    
    public ResearchProject takeResearchProject() throws NumberFormatException, IOException {
    	System.out.println("index of project to join:");
		DataBase dataBase=DataBase.getInstance();
		for(ResearchProject rp:dataBase.getProjects()) {
			System.out.println(rp.getName());
		}
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		int index=Integer.parseInt(bReader.readLine());
		return dataBase.getProjects().elementAt(index);
    }
    public void joinResearchProject() throws Exception {
    	ResearchProject rpr=takeResearchProject(); 
    	rpr.addParticipant(this);
    }
    public void leaveFromProject() throws Exception {
    	ResearchProject rpr=takeResearchProject(); 
    	rpr.leaveParticipant(this);
    }
    public void createResearchProject() throws IOException {
    	System.out.println("what is the name of the project:");
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		String nameProject=bReader.readLine();
    	System.out.println("talk about project topic:");
		String topicProject=bReader.readLine();
		DataBase dataBase=DataBase.getInstance();
		dataBase.addResearchProject(new ResearchProject(nameProject,topicProject,this));
    }
    public boolean manangeResearchPapper() throws IOException {
    	ResearchPaper rPaper =takeResearchPaper();
    	
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
    	
    	System.out.println("\nWhat you want to do:\n1)change name\n2)change citations");
    	int choiceMananage=Integer.parseInt(bReader.readLine());
    	if(choiceMananage==1){
    		System.out.println("new name for research papper:");
        	String newName=bReader.readLine();
        	rPaper.setName(newName);	
    	}else {
    		System.out.println("new citation number for papper:");
        	int newCitation=Integer.parseInt(bReader.readLine());
        	rPaper.setCitations(newCitation);
    	}

        return true;
    }
    public Vector<ResearchPaper> getPapers(){
    	return this.Papers;
    }
    public ResearchPaper takeResearchPaper() throws NumberFormatException, IOException {
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
    	System.out.println("give index of research papper:");
    	for(ResearchPaper rp:Papers) {
    		System.out.println(rp.getName());
    	}
    	int choicePappers=Integer.parseInt(bReader.readLine());
    	int i=0;
    	for(ResearchPaper rp:Papers) {
    		if(i==choicePappers) {
    	    	return Papers.elementAt(i);
    		}
    		i++;
    		
    	}
		return null;
    	
    }
    public boolean createResearchPapper() throws IOException {
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		
    	System.out.println("name of research papper:");
    	String name=bReader.readLine();
    	
    	System.out.println("number of citations of research papper:");
    	int citationNumber=Integer.parseInt(bReader.readLine());
    	
    	System.out.println("number of pages:");
    	int numberOfPages=Integer.parseInt(bReader.readLine());

    	ResearchPaper rp =new ResearchPaper(name,citationNumber,this,numberOfPages);

    	this.Papers.add(rp);
    	DataBase dataBase=DataBase.getInstance();
    	dataBase.getJournal().notifyUsers(rp);
		return false;
    	
    }
    public boolean addAuthorToPapper(String iDToAdd) throws Exception {
    	ResearchPaper rPaper =takeResearchPaper();
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		
		DataBase dataBase=DataBase.getInstance();
		Vector<User> users=dataBase.getUsers();
		for(User u:users) {
			if(u.getID().equals(iDToAdd)) {
				if(u instanceof Researcher) {
					rPaper.addAuthors((Researcher) u);
				}else {
					throw new Exception("this user is not Researcher!!!");	
				}
			}
		}
		return false;
    }
    public boolean removeAuthorFromPapper(String iDToAdd) throws Exception {
    	ResearchPaper rPaper =takeResearchPaper();
    	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader bReader=new BufferedReader(isr);
		
		DataBase dataBase=DataBase.getInstance();
		Vector<User> users=dataBase.getUsers();
		for(Researcher u:rPaper.getAuthors()) {
			if(u.getID().equals(iDToAdd)) {
					rPaper.removeAuthors((Researcher) u);
			}
		}
		return false;
    }
	public void run() throws Exception {
		System.out.println("Welcome!");
		 while(true){
				InputStreamReader isr=new InputStreamReader(System.in);
				BufferedReader bReader=new BufferedReader(isr);
				System.out.println("What do you want to do?\n 1)create new Research Papper\n 2) manange,change Research papper  \n 3) add Authors to project  \n 4) remove author from project  \n 5) see research pappers   \n 6)subscribe to journal\n7)   calculate h-index\n 8) create research project\n "
						+ "9) join to research project\n 10) leave from research project\n 11) add research pappers to research project\n 12) Send Order\n 13) Exit");
				int choice =Integer.parseInt( bReader.readLine());
				if(choice==1){
					createResearchPapper();
				}
				else if (choice==2){
					manangeResearchPapper();
				}
				else if (choice==3){
					System.out.println("id of researcher to add:");
					String loginToAddPapper=bReader.readLine();
					addAuthorToPapper(loginToAddPapper);
				}
				else if (choice==4){
					System.out.println("id of researcher to remove:");
					String loginToRemovePapper=bReader.readLine();
					removeAuthorFromPapper(loginToRemovePapper);
				}else if (choice==5){
			        System.out.println("Sorted by:\n 1)date\n 2)citations\n 3)num of pages:");
			        int choiceSortPappers=Integer.parseInt(bReader.readLine());
			        if(choiceSortPappers==1) {
				        printPapers(Comparator.comparing(ResearchPaper::getPublishedDate));

			        }else if(choiceSortPappers==2) {
				        printPapers(Comparator.comparing(ResearchPaper::getCitations));

			        }else {
				        printPapers(Comparator.comparing(ResearchPaper::getNumOfPages));
			        }
				}else if (choice==6){
					super.subscribeToJournal();
				}else if (choice==7){
					this.hIndex=calculateHIndex();
					System.out.println("new h-index is:"+this.hIndex);
				}
				else if (choice==8){
					createResearchProject();
				}else if (choice==9){
					joinResearchProject();
				}else if (choice==10){
					leaveFromProject();
				}else if (choice==11){
					addPapperToProject();
				}else if (choice==12){
					super.sendOrderToTechSupport();
				}else if (choice==13){
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
    public void printPapers(Comparator<ResearchPaper> comparator) {
        Papers.sort(comparator);
        for (ResearchPaper paper : Papers) {
            System.out.println(paper.getName());
        }
    }
    public int calculateHIndex() {
    	int n = Papers.size();
        int[] citations = new int[n];

        for (int i = 0; i < n; i++) {
            citations[i] = Papers.get(i).getCitations();
        }

        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            int count = n - i;
            if (citations[i] >= count) {
                hIndex = count;
            } else {
                break;
            }
        }
        return hIndex;
    }
    public void addPapperToProject() throws NumberFormatException, IOException {
    	ResearchPaper rpp=takeResearchPaper();
    	ResearchProject rpr=takeResearchProject();
    	rpr.addPublishedPaper(rpp);
    	
    }
        
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Researcher other = (Researcher) obj;
		return Objects.equals(Papers, other.Papers) && hIndex == other.hIndex;
	}
    @Override
	public String toString() {
		return super.toString()+"Researcher [hIndex=" + hIndex + ", Papers=" + Papers + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Papers, hIndex);
	}
    
}