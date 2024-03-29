package org.example.JobPortalApplication.repository;

import org.example.JobPortalApplication.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPortalRepo extends JpaRepository<JobPost,String> {
    List<JobPost> findByPostProfileOrPostDescContaining(String postProfile,String postDesc);
}
