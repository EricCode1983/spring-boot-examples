package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.Passport;
import com.neo.springbootjpamapping.entity.Review;
import com.neo.springbootjpamapping.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class JpaExecute {


    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PassportRepositoryByJpa passportRepositoryByJpa;

    @Autowired
    private StudentRepositoryByJpa studentRepositoryByJpa;

    @Autowired
    private CourseRepositoryByJpa courseRepositoryByJpa;

    @Autowired
    private ReviewRepositoryByJpa reviewRepositoryByJpa;

    public void saveStudentWithPassport(){

        Passport passport=new Passport("C123456");
        passportRepositoryByJpa.save(passport);
        Student student=new Student("ERIC");
        student.setPassport(passport);
        studentRepositoryByJpa.save(student);

    }

    public void retriveStudentWithPassport(){


     Student student= studentRepositoryByJpa.findById(20001l).orElse(new Student());
     Passport passport=student.getPassport();
     Student student1=passport.getStudent();
     logger.info("passport detail-> {}",passport.toString());

    }


    public void deleteStudent()
    {
        studentRepositoryByJpa.deleteById(2l);
    }

    public void deletePassport(){
        passportRepositoryByJpa.deleteById(1l);
    }


        public void addReviewsForCourse(){

        Course course= courseRepositoryByJpa.findById(10001L).orElseThrow(() -> new IllegalArgumentException("Not found"));
        logger.info("course.getReviews()->",course.getReviews());

        Review review1=new Review("5","greate teacher");
        Review review2=new Review("4","on time teacher");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        reviewRepositoryByJpa.save(review1);
        reviewRepositoryByJpa.save(review2);
    }
}
