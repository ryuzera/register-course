package com.rocketseat.register_course.infrastructure.exception;

public class CourseCategoryNotFoundException extends RuntimeException {
    public CourseCategoryNotFoundException(String message) {
        super(message);
    }
}
