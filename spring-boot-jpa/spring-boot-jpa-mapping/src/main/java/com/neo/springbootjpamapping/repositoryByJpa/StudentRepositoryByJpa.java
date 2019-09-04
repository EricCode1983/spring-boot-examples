package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryByJpa  extends JpaRepository<Student,Long> {
}
