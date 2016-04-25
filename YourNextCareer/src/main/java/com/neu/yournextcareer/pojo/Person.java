package com.neu.yournextcareer.pojo;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="personTable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name="personID", unique=true, nullable=false)
	private long personID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
    private String password;
	
	@Column(name="confirmPassword")
    private String confirmPassword;
	
	@Column(name="emailID", unique=true, nullable=false)
	private String emailID;
	
	@Column(name="confirmEmailID")
	private String confirmEmailID;
	
	public Person(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	//	checkPassword();
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
		//checkEmailID();
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		//checkPassword();
	}

	public String getConfirmEmailID() {
		return confirmEmailID;
	}

	public void setConfirmEmailID(String confirmEmailID) {
		this.confirmEmailID = confirmEmailID;
	//	checkEmailID();
	}

	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	
	/**private void checkPassword() {
	    if(this.password == null || this.confirmPassword == null){
	        return;
	    }else if(!this.password.equals(confirmPassword)){
	        this.confirmPassword = null;
	    }
	}
	private void checkEmailID() {
	    if(this.emailID == null || this.confirmEmailID == null){
	        return;
	    }else if(!this.emailID.equals(confirmEmailID)){
	        this.confirmEmailID = null;
	    }
	}**/
}