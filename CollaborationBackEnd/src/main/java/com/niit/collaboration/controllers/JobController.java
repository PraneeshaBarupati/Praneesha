package com.niit.collaboration.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplication;
import com.niit.collaboration.model.User;

public class JobController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	Job job;
	
	@Autowired
	User user;


	@Autowired
	JobDAO jobDAO;

	@Autowired
	JobApplication jobApplication;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/getAllJobs/", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getAllOpenedJobs() {
		List<Job> jobs = (List<Job>) jobDAO.getAllOpenedJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}

	@RequestMapping(value = "/getMyAppliedJobs/", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getMyAppliedJobs() {
		List<Job> jobs = jobDAO.getAppliedJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}

	@RequestMapping(value = "/getJobDetails/{jobID}", method = RequestMethod.GET)
	public ResponseEntity<Job> getJobDetails(@RequestParam("jobID") String jobID) {
		Job job = jobDAO.get(jobID);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/postAJob", method = RequestMethod.GET)
	public ResponseEntity<Job> postAJob(@RequestBody Job job) {
		job.setStatus('V');
		jobDAO.save(jobApplication);
		if (jobDAO.save(jobApplication) == false) {
			job.setErrorcode("404");
			job.setErrormessage("Not able to Post a job");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/applyForJob/{jobID}", method = RequestMethod.PUT)
	public ResponseEntity<Job> applyForJob(@RequestParam("jobID") String jobID, HttpSession session) {
		User loggedInUserID = (User) session.getAttribute("loggedInUserID");
		jobApplication = jobDAO.getJobApplication(jobID);
		jobApplication.setUserID(loggedInUserID.getId());
		jobApplication.setStatus("N");
		if (jobDAO.save(jobApplication) == false) {
			job.setErrorcode("404");
			job.setErrormessage("Not able to apply for the job");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/selectUser/{userID}/{jobID}", method = RequestMethod.PUT)
	public ResponseEntity<Job> selectUser(@RequestParam("userID") String userID, @RequestParam("jobID") String jobID,
			HttpSession session) {
		jobApplication = jobDAO.getJobApplication(userID, jobID);
		jobApplication.setStatus("S");
		if (jobDAO.save(jobApplication) == false) {
			job.setErrorcode("404");
			job.setErrormessage("Not able to change the application status as 'selected'");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/callForInterview/{userID}/{jobID}", method = RequestMethod.PUT)
	public ResponseEntity<Job> callForInterview(@RequestParam("userID") String userID,
			@RequestParam("jobID") String jobID, HttpSession session) {
		jobApplication = jobDAO.getJobApplication(userID, jobID);
		jobApplication.setStatus("C");
		if (jobDAO.save(jobApplication) == false) {
			job.setErrorcode("404");
			job.setErrormessage("Not able to change the application status as 'call for interwiew'");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/rejectJobApplication/{userID}/{jobID}", method = RequestMethod.PUT)
	public ResponseEntity<Job> rejectJobApplication(@RequestParam("userID") String userID,
			@RequestParam("jobID") String jobID, HttpSession session) {
		jobApplication = jobDAO.getJobApplication(userID, jobID);
		jobApplication.setStatus("R");
		if (jobDAO.save(jobApplication) == false) {
			job.setErrorcode("404");
			job.setErrormessage("Not able to reject the application");
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

}
