package com.neu.yournextcareer.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.ApplicationsDAO;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.JobSeeker;

@Controller
public class EmployerResumeDownloadController {
	@RequestMapping(value="download/{appJobid}",method = RequestMethod.GET)
	public String download(@PathVariable("appJobid")
	long aid, HttpServletResponse response) throws Exception {
	
		ApplicationsDAO appsDAO = null;

		Applications aj=null;
		JobSeeker jobSeeker = null;

		try {

			appsDAO = new ApplicationsDAO();
			aj=appsDAO.get(aid);
			jobSeeker = (JobSeeker) aj.getPerson();
			System.out.println(jobSeeker.getResume().getResumeFileName());

			response.setHeader("Content-Disposition", "inline;filename=\"" +jobSeeker.getResume().getResumeFileName()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(jobSeeker.getResume().getResumeFileType());
			IOUtils.copy(jobSeeker.getResume().getContent().getBinaryStream(), out);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return null;
	}
}
