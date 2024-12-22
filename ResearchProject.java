package researcher;

import java.util.Vector;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;


public class ResearchProject  implements Serializable{
	private String name;
    private String topic;
    private Vector<ResearchPaper> publishedPapers=new Vector<ResearchPaper>();
    private Vector<Researcher> participants=new Vector<Researcher>();

 
   
    public ResearchProject(String name, String topic,Researcher r) {
		this.name = name;
		this.topic = topic;
		participants.add(r);
	}

	private String getTopic() {
        return this.topic;
    }
    
    private void setTopic(String topic) {
        this.topic = topic;
    }
    

    private Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }
   
    private void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    

    public boolean addPublishedPaper(ResearchPaper paper) {
        return publishedPapers.add(paper);
    }
    
    public boolean removePublishedPaper(ResearchPaper paper) {
        return publishedPapers.remove(paper);
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "topic='" + topic + '\'' +
                ", publishedPapers=" + publishedPapers+
                '}';
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResearchProject other = (ResearchProject) obj;
		return Objects.equals(name, other.name) && Objects.equals(participants, other.participants)
				&& Objects.equals(publishedPapers, other.publishedPapers) && Objects.equals(topic, other.topic);
	}
    @Override
	public int hashCode() {
		return Objects.hash(name, participants, publishedPapers, topic);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Researcher> getParticipants() {
		return participants;
	}

	public void setParticipants(Vector<Researcher> participants) {
		this.participants = participants;
	}
	public void addParticipant(User u) throws Exception {
		if(!(u instanceof Researcher)){
			throw new Exception("you are not researcher!!!");
		}
		else if(participants.contains((Researcher)u)) {
			System.out.println("you are alredy here,");
		}else {
			participants.add((Researcher)u);
		}
	}
	public void leaveParticipant(User u) throws Exception {
		if(!participants.contains((Researcher)u)) {
			System.out.println("you are not alredy here,");
		}else {
			participants.remove((Researcher) u);
		}
	}
}

