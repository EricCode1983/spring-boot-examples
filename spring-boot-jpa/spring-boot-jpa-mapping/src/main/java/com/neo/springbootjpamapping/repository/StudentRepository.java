package com.neo.springbootjpamapping.repository;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.Passport;
import com.neo.springbootjpamapping.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id){
       return em.find(Student.class,id);
    }


    public void saveStudentWithPassport(){

        Passport passport=new Passport("Z123456");
        em.persist(passport);
        Student student=new Student("Mike");
        student.setPassport(passport);
        em.persist(student);

    }


}
