package com.neo.springbootjpamapping;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.FullTimeEmployee;
import com.neo.springbootjpamapping.entity.PartTimeEmployee;
import com.neo.springbootjpamapping.repository.CourseRepository;
import com.neo.springbootjpamapping.repository.StudentRepository;
import com.neo.springbootjpamapping.repositoryByJpa.FulltimeEmployeeRepositoryByJpa;
import com.neo.springbootjpamapping.repositoryByJpa.JpaExecute;
import com.neo.springbootjpamapping.repositoryByJpa.ParttimeEmployeeRepositoryByJpa;
import com.neo.springbootjpamapping.repositoryByJpa.StudentRepositoryByJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootJpaMappingApplication implements  CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentRepositoryByJpa studentRepositoryByJpa;

    @Autowired
    private JpaExecute jpaExecute;

    @Autowired
    private FulltimeEmployeeRepositoryByJpa fulltimeEmployeeRepositoryByJpa;

    @Autowired
    private ParttimeEmployeeRepositoryByJpa parttimeEmployeeRepositoryByJpa;

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaMappingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//       Course course= courseRepository.findById(10001L);
         //studentRepository.saveStudentWithPassport();
       //ogger.info("Course 10001 -> {}",course);
       // jpaExecute.addReviewsForCourse();
        //studentRepositoryByJpa.findById()

        //fulltimeEmployeeRepositoryByJpa.save(new FullTimeEmployee("Jack",new BigDecimal("10000")));
        //parttimeEmployeeRepositoryByJpa.save(new PartTimeEmployee("Mike",new BigDecimal("50")));


    }
}
