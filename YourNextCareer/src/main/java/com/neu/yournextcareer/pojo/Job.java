package com.neu.yournextcareer.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="jobTable")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="jobID", unique=true, nullable=false)
	private long jobID;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="employerID")
    public Employer employer;	
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="job")
	private Set<Applications> apps = new HashSet<Applications>();

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@Column(name="jobTitle")
	private String jobTitle;

	@Column(name="jobType")
	private String jobType;
	
	@Column(name="jobCategory")
	private String jobCategory;
	
	@Column(name="jobDescription")
	private String jobDescription;
	
	@Column(name="jobRequirement")
	private String jobRequirement;

	@Column(name="jobResponsibilities")
	private String jobResponsibilities;
	
	@Column(name="jobLocation")
	private String jobLocation;
	
	@Column(name="jobCompany")
	private String jobCompany;
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobRequirement() {
		return jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}

	public String getJobResponsibilities() {
		return jobResponsibilities;
	}

	public void setJobResponsibilities(String jobResponsibilities) {
		this.jobResponsibilities = jobResponsibilities;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobCompany() {
		return jobCompany;
	}

	public void setJobCompany(String jobCompany) {
		this.jobCompany = jobCompany;
	}

	public Set<Applications> getApps() {
		return apps;
	}

	public void setApps(Set<Applications> apps) {
		this.apps = apps;
	}

	public long getJobID() {
		return jobID;
	}

	public void setJobID(long jobID) {
		this.jobID = jobID;
	}

/**	@Column(name="jobStatus")
	private boolean jobStatus; **/
	

}
