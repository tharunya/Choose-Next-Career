package com.neu.yournextcareer.pojo;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name="jobSeekerTable")
@PrimaryKeyJoinColumn(name="personID")
public class JobSeeker extends Person{

	@OneToMany(fetch= FetchType.EAGER, mappedBy="person")
	private Set<Applications> apps = new HashSet<Applications>();

	@OneToOne
	private Resume resume;
	
    public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public JobSeeker() {
    }
	public Set<Applications> getApps() {
		return apps;
	}

	public void setApps(Set<Applications> apps) {
		this.apps = apps;
	}
	
	public void addApps(Applications app) {
        getApps().add(app);
    }

}