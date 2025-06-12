package com.rocketseat.register_course.business;

import com.rocketseat.register_course.infrastructure.entity.Course;
import com.rocketseat.register_course.infrastructure.exception.CourseCategoryNotFoundException;
import com.rocketseat.register_course.infrastructure.exception.CourseNotFoundException;
import com.rocketseat.register_course.infrastructure.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void saveCourse(Course course) {
        courseRepository.saveAndFlush(course);
    }

    public void deleteCourseById(UUID id) {
        courseRepository.delete(courseRepository.findById(id).get());
    }

    public void findCourseById(Course course) {
        courseRepository.findById(course.getId());
    }

    public Course findCoursesByCategory(String category) {
        return courseRepository.findByCategory(category).orElseThrow(
                () -> new CourseCategoryNotFoundException("Course category " + category + " not found")
        );
    }

    public void updateCourseById(UUID id, Course course) {
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));

        Course courseUpdated = Course.builder()
                .id(courseToUpdate.getId())
                .name(course.getName() != null ? course.getName() : courseToUpdate.getName())
                .category(course.getCategory() != null ? course.getCategory() : courseToUpdate.getCategory())
                .build();

        courseRepository.saveAndFlush(courseUpdated);
    }
}
