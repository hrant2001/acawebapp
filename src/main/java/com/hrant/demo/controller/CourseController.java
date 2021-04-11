package com.hrant.demo.controller;

import com.hrant.demo.model.Course;
import com.hrant.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course addCourse(@Valid @NonNull @RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping(path = "{id}")
    public Course getCourseById(@PathVariable("id") int id) {
        return courseService.getCourseById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourseById(@PathVariable("id") int id) {
        courseService.deleteCourse(id);
    }

//    @PutMapping(path = "{id}")
//    public int updateCourse(@Valid @NotNull @RequestBody Course courseToUpdate, @PathVariable("id") int id) {
//        return courseService.updateCourse(courseToUpdate, id);
//    }
}
