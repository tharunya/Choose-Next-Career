package com.neu.yournextcareer.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employerTable")
@PrimaryKeyJoinColumn(name="personID")
public class Employer extends Person{

	public Employer() {
	}

	@OneToMany(fetch= FetchType.EAGER, mappedBy="employer")
	public Set<Job> jobs = new HashSet<Job>();
	
	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public void addJobs(Job job) {
		getJobs().add(job);
	}
}
