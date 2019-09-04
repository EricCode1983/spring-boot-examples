package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoryByJpa extends JpaRepository<Course,Long> {

    public Course findByName(String  name);
}
