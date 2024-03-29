package org.example.JobPortalApplication.service;

import org.example.JobPortalApplication.model.JobPost ;
import org.example.JobPortalApplication.repository.JobPortalRepo ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPortalServices {

    private JobPortalRepo repo;

    public JobPortalRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(JobPortalRepo repo) {
        this.repo = repo;
    }

    public void addJob(JobPost job) {
        repo.save(job);
    }

    public List<JobPost> getJobs() {
        //int error=10/0;
        List<JobPost> list=repo.findAll();
        return list;
    }

    public JobPost getJobAt(String postID) {
        Optional<JobPost> job=repo.findById(postID);
        return job.orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJobAt(String ID) {
        repo.deleteById(ID);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileOrPostDescContaining(keyword,keyword);
    }

    public String loadDefault() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                        new JobPost("101A", "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost("101B", "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost("101C", "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost("101D", "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost("101E", "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

        ));
        repo.saveAll(jobs);
        return "success";
    }
}
