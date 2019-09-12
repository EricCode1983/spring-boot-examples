package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.SpringBootJpaMappingApplication;
import com.neo.springbootjpamapping.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJpaMappingApplication.class)

@Transactional
public class JpaExecuteTest {

    @Autowired
    private EntityManager em;


    @Autowired
    private CourseRepositoryByJpa courseRepositoryByJpa;

    @Autowired
    private ReviewRepositoryByJpa reviewRepositoryByJpa;

    @Autowired
    private StudentRepositoryByJpa studentRepositoryByJpa;

    @Autowired
    private FulltimeEmployeeRepositoryByJpa fulltimeEmployeeRepositoryByJpa;

    @Autowired
    private ParttimeEmployeeRepositoryByJpa parttimeEmployeeRepositoryByJpa;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Test
    public void saveStudentWithPassport() {
    }

    @Test
    public void retriveStudentWithPassport() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }


    @Test
    public void retrivePassport() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    public void deleteStudent() {
    }

    @Test
    public void deletePassport() {
    }

    @Test
    public void addReviewsForCourse() {
        Course course= courseRepositoryByJpa.findById(10001L).orElseThrow(() -> new IllegalArgumentException("Not found"));
        logger.info("course.getReviews()->",course.getReviews());

        Review review1=new Review("5","greate teacher");
        Review review2=new Review("4","on time teacher");

       // course.addReview(review1);
        review1.setCourse(course);

        //course.addReview(review2);
        review2.setCourse(course);

        reviewRepositoryByJpa.save(review1);
        reviewRepositoryByJpa.save(review2);



    }

    @Test
    public void retrieveCourseByReview()
    {
       Review review= reviewRepositoryByJpa.findById(50001L).orElseThrow(() -> new IllegalArgumentException("Not found"));
       logger.info("--------------------------------------------");
       logger.info("course -> {}", review.getCourse());
    }

    @Test
    public void retrieveStudentAndCourses()
    {
        Student student =studentRepositoryByJpa.findById(20001L).orElseThrow(() -> new IllegalArgumentException("Not found"));
        List<Course> courseList= student.getCourses();
        logger.info("student->{}",student);
        logger.info("courses->{}",courseList);
    }



    @Test
    public void retrieveFirst100Course()
    {
        List<Course> lstCourses= courseRepositoryByJpa.findCoursesMoreThan2Students();
        logger.info("List Course->{}",lstCourses);
    }




}