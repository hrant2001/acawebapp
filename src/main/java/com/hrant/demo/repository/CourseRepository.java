package com.hrant.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository<T> {

    int insertCourse(T t);

    List<T> selectAllCourse();

    Optional<T> selectCourseById(int id);

    int deleteCourseById(int id);

    int updateCourseById(T t, int id);
}
