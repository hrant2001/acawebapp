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

    public int addCourse(Course course) {
        return courseRepository.insertCourse(course);
    }

    public List<Course> getAllCourse() {
        return courseRepository.selectAllCourse();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.selectCourseById(id);
    }

    public int deleteCourse(int id) {
        return courseRepository.deleteCourseById(id);
    }

    public int updateCourse(Course newCourse, int id) {
        return courseRepository.updateCourseById(newCourse, id);
    }
}
