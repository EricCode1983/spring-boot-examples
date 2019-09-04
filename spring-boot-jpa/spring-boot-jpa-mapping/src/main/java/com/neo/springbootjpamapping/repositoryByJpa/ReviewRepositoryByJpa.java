package com.neo.springbootjpamapping.repositoryByJpa;

import com.neo.springbootjpamapping.entity.Course;
import com.neo.springbootjpamapping.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryByJpa extends JpaRepository<Review,Long> {
}
