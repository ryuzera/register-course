package com.rocketseat.register_course.controller;

import com.rocketseat.register_course.business.CourseService;
import com.rocketseat.register_course.infrastructure.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")

// Para injetar o construtor do service
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Course> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(courseService.findCoursesByCategory(category));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCourseById(@RequestParam UUID id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<Void> updateCourse(@RequestParam UUID id, @RequestBody Course course) {
        courseService.updateCourseById(id, course);
        return ResponseEntity.ok().build();
    }
}
