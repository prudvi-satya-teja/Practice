package com.project.JobPortal.Service;


import com.project.JobPortal.Model.JobPost;
import com.project.JobPortal.Repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {
    
    @Autowired
    private JobPostRepo jobPostRepo;

    public List<JobPost> getAllJobs() {
        return jobPostRepo.findAll();
    }

    public JobPost getJobById(int postId) {
        Optional<JobPost> post =  jobPostRepo.findById(postId);
        return post.orElseGet(JobPost::new);
    }

    public JobPost addJob(JobPost jobPost) {
        jobPostRepo.save(jobPost);
        return jobPost;
    }

    public JobPost updateJob(JobPost jobPost) {
        jobPostRepo.save(jobPost);
        return jobPost;
    }

    public void deleteJob(int postId) {
        jobPostRepo.deleteById(postId);
    }

    public List<JobPost> findByKeyword(String keyword) {
        return  jobPostRepo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
