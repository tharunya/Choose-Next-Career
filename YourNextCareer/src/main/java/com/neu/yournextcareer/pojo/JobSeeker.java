package com.neu.yournextcareer.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="jobSeekerTable")
@PrimaryKeyJoinColumn(name="personID")
public class JobSeeker extends Person{

	@OneToMany(fetch= FetchType.EAGER, mappedBy="person")
	private Set<Applications> apps = new HashSet<Applications>();

	@OneToOne
	private Resume resume;

    public JobSeeker() {
    }
 
	public Set<Applications> getApps() {
		return apps;
	}

	public void setApps(Set<Applications> apps) {
		this.apps = apps;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public void addApps(Applications app) {
        getApps().add(app);
    }

    
}