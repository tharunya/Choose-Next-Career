package com.neu.yournextcareer.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="jobTable")
@PrimaryKeyJoinColumn(name="jobID")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="jobID", unique=true, nullable=false)
	private long jobID;

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

	@Column(name="jobPostedDate")
	private Date jobPostedDate; 

	@Column(name="jobAppliedDate")
	private Date jobAppliedDate;
	
	@Column(name="jobStatusChangedDate")
	private Date jobStatusChangedDate;
	
	@Column(name="jobStatus")
	private String jobStatus;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="employerID")
    public Employer employer;	
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="job")
	private Set<Applications> apps = new HashSet<Applications>();
	
	public long getJobID() {
		return jobID;
	}

	public void setJobID(long jobID) {
		this.jobID = jobID;
	}

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

	public String getDescription() {
		return jobDescription;
	}

	public void setDescription(String jobDescription) {
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

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Date getJobPostedDate() {
		return jobPostedDate;
	}

	public void setJobPostedDate(Date jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
	}

	public Date getJobAppliedDate() {
		return jobAppliedDate;
	}

	public void setJobAppliedDate(Date jobAppliedDate) {
		this.jobAppliedDate = jobAppliedDate;
	}

	public Date getJobStatusChangedDate() {
		return jobStatusChangedDate;
	}

	public void setJobStatusChangedDate(Date jobStatusChangedDate) {
		this.jobStatusChangedDate = jobStatusChangedDate;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Set<Applications> getApps() {
		return apps;
	}

	public void setApps(Set<Applications> apps) {
		this.apps = apps;
	}

}
