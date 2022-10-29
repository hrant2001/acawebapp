package com.hrant.demo.controller;

import com.hrant.demo.model.Course;
import com.hrant.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Course> addCourse(@Valid @NonNull @RequestBody Course course) {
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() {
        return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") int id) {
        return new ResponseEntity<>(courseService.getCourseById(id)
                .orElse(null), HttpStatus.OK);
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<Course> getCourseByName(@PathVariable("name") String courseName) {
        return new ResponseEntity<>(courseService.getCourseByName(courseName)
                .orElse(null), HttpStatus.OK);
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
