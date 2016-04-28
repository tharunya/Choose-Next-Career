package com.neu.yournextcareer.pojo;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="resume")
public class Resume {
	
	/**@Column(name="resume")
	private CommonsMultipartFile resume; **/
	
	@Id
	@GeneratedValue
	@Column(name="rID", unique =true, nullable=false)
	private long rID;
	
	@Column(name="resumeContent")
	@Lob
	private Blob content;
	
	@Column(name="resumeFileType")
	private String resumeFileType;
	
	@Column(name="resumeFileName")
	private String resumeFileName;

/**	@Column(name="resumeTitle")
	private String resumeTitle;**/
	
	@Column(name="skills")
	private String skills;
	/** CommonsMultipartFile getResume() {
		return resume;
	}

	public void setResume(CommonsMultipartFile resume) {
		this.resume = resume;
	} **/

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getResumeFileType() {
		return resumeFileType;
	}

	public void setResumeFileType(String resumeFileType) {
		this.resumeFileType = resumeFileType;
	}

	public String getResumeFileName() {
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	/**public String getResumeTitle() {
		return resumeTitle;
	}

	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}**/

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}
