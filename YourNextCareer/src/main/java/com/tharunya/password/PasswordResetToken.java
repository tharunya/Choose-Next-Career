package com.tharunya.password;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.neu.yournextcareer.pojo.Person;

import javax.persistence.FetchType;

@Entity
public class PasswordResetToken {
	
/**	private static final int EXPIRATION = 60*24;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long pid;

private String token;

@OneToOne(targetEntity =Person.class, fetch=FetchType.EAGER)
@JoinColumn(nullable = false, name="user_id")
private Person person;

private Date expiryDate;

public Long getPid() {
	return pid;
}

public void setPid(Long pid) {
	this.pid = pid;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public Person getPerson() {
	return person;
}

public void setPerson(Person person) {
	this.person = person;
}

public Date getExpiryDate() {
	return expiryDate;
}

public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
}

public static int getExpiration() {
	return EXPIRATION;
}**/
}