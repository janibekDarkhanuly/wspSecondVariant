package student;
import java.util.Vector;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.HashMap;

import employee.*;
import enums.*;
import researcher.*;
import student.*;
import system.*;




public class StudOrganizations {
	private ListStudOrganizations organization;
    private Vector<User> members;

	
    
	public ListStudOrganizations getOrganization() {
		return organization;
	}



	public void setOrganization(ListStudOrganizations organization) {
		this.organization = organization;
	}



	public Vector<User> getMembers() {
		return members;
	}



	public void setMembers(Vector<User> members) {
		this.members = members;
	}



	public void showAllStudorganizations() {
		for (User m : members) {
			System.out.println(m);
		}
	}
    
}
