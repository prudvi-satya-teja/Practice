package com.project.JobPortal.Controller;

import com.project.JobPortal.Model.JobPost;
import com.project.JobPortal.Service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("/jobs")
    public List<JobPost> getAllJobs() {
        return jobPostService.getAllJobs();
    }

    @GetMapping("/job/{postId}")
    public JobPost getJobById(@PathVariable int postId) {
        return jobPostService.getJobById(postId);
    }

    @PostMapping("/job")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        return jobPostService.addJob(jobPost);
    }

    @PutMapping("/job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        return jobPostService.updateJob(jobPost);
    }

    @DeleteMapping("/job/{postId}")
    public String deleteJob(@PathVariable int postId) {
        jobPostService.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("/keyword/{keyword}")
    public List<JobPost> getJobsByKeyword(@PathVariable String keyword) {
        return jobPostService.findByKeyword(keyword);
    }


}
