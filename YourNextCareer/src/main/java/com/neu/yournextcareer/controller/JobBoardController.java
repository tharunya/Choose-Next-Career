package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.JobSeekerDAO;

@Controller
public class JobBoardController {
	@RequestMapping(method = RequestMethod.GET, value="/jobBoard.htm")
	public String displayJobBoard( Model model) {
		
		JobDAO jd= new JobDAO();
			Long js = jd.jobSize();
				model.addAttribute("js", js);
		return "jobBoard";
	}
}
