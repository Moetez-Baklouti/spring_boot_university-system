package com.app.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    public Course saveCourse(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    public void DeleteCourse(long parseLong) {
        courseRepository.deleteById(parseLong);
    }
}
