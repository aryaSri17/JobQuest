package org.example.JobPortalApplication.controllers;

import org.example.JobPortalApplication.model.JobPost ;
import org.example.JobPortalApplication.service.JobPortalServices ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class RestControllers {

    @Autowired
    private JobPortalServices services;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return services.getJobs();
    }

    @GetMapping("jobPost/{ID}")
    public JobPost getJobAt(@PathVariable String ID){
        JobPost job=services.getJobAt(ID);
        System.out.println(job);
        return job;
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return services.search(keyword);
    }

    @GetMapping("jobPosts/load")
    public String load(){
        return services.loadDefault();
    }

    @PostMapping("jobPosts")
    public JobPost add(@RequestBody JobPost job){
        services.addJob(job);
        return services.getJobAt(job.getPostID());
    }

    @PutMapping("jobPosts")
    public JobPost updateJobPost(@RequestBody JobPost job){
        services.updateJob(job);
        return services.getJobAt(job.getPostID());
    }

    @DeleteMapping("jobPost/{ID}")
    public void deleteJobPost(@PathVariable String ID){
        services.deleteJobAt(ID);
    }
}
