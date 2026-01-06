package com.aman.JobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aman.JobApp.model.JobPost;
import com.aman.JobApp.service.JobService;





@Controller
public class JobController {
	
	@Autowired
	private JobService services;
	
	@RequestMapping({"/", "home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("addjob")
	public String addJob() {
		return "addjob";
	}
	
	@PostMapping("handleForm")
	public String handleForm(JobPost jobPost) {
		services.addJob(jobPost);
		return "success";
	}
	
	
	@GetMapping("viewalljobs")
	public String viewJobs(Model m) {
		List<JobPost> jobs = services.getAllJobs();
		m.addAttribute("jobPosts", jobs);
		return "viewalljobs";
	}
}
