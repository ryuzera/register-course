package com.rocketseat.register_course.infrastructure.repository;

import com.rocketseat.register_course.infrastructure.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    Optional<Course> findByCategory(String category);

}
