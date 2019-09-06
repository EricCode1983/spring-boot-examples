package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.FullTimeEmployee;
import com.neo.springbootjpamapping.entity.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FulltimeEmployeeRepositoryByJpa extends JpaRepository<FullTimeEmployee,Long> {


    public FullTimeEmployee findByName(String  name);
}
