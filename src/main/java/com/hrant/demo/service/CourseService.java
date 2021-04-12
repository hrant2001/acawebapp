package com.hrant.demo.service;

import com.hrant.demo.model.Course;
import com.hrant.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> getCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

//    public int updateCourse(Course newCourse, int id) {
//        return courseRepository.updateCourseById(newCourse, id);
//    }
}
