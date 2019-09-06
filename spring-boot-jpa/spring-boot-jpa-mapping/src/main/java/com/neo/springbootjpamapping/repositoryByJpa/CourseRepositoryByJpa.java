package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface CourseRepositoryByJpa extends JpaRepository<Course,Long> {

    public Course findByName(String  name);

    @Query(value = "select * from course",nativeQuery = true)
    public List<Course> findCourseAtLeast2Students();
}
