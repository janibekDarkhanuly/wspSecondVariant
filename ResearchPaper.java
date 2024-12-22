package researcher;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Date;
import java.util.Set;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Vector;


public class ResearchPaper  implements Serializable{
    
    private String name;
    private int numOfPages;
    private int citations;
    private Vector<Researcher> authors = new Vector<Researcher>();
    private LocalDate publishedDate;
    
    public ResearchPaper() {
    	
    }public ResearchPaper(String name,int citations,Researcher r,int numOfPages){
    	this.name=name;
    	this.citations=citations;
    	this.publishedDate=LocalDate.now();
    	this.numOfPages=numOfPages;
    	this.authors.add(r);
    }
    
    public String getName() {
        return this.name;
    }
    
  
    public void setName(String name) {
        this.name = name;
    }
    
    
    public int getCitations() {
        return this.citations;
    }
    
    public void setCitations(Integer citations) {
        this.citations = citations;
    }
    public String getCitation(Format f) {
    	this.citations++;
    	if(f==Format.PlainText) {
    		return this.authors.elementAt(0).getName()+", "+this.name+", "+this.citations+", "+this.numOfPages+", "+this.publishedDate.toString();
    	}else {
    		return this.toString();
    	}
    	
    }
 
    public void setAuthors(Vector<Researcher> authors) {
        this.authors = authors;
    }
    public void addAuthors(Researcher authors) {
        this.authors.add(authors);
    }
    public void removeAuthors(Researcher authors) {
        this.authors.remove(authors);
    }
    public LocalDate getPublishedDate() {
        return this.publishedDate;
    }
    
    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    public Vector<Researcher> getAuthors() {
        return authors;
    }


    @Override
	public String toString() {
		return "ResearchPaper [name=" + name + ", numOfPages=" + numOfPages + ", citations=" + citations + ", authors="
				+ authors.elementAt(0).getName() + ", publishedDate=" + publishedDate + "]";
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResearchPaper)) return false;
        ResearchPaper that = (ResearchPaper) o;
        return citations == that.citations &&
                name.equals(that.name) &&
                authors.equals(that.authors) &&
                publishedDate.equals(that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, citations, authors, publishedDate);
    }
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
    
    
}
