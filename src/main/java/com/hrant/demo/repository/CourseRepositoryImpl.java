package com.hrant.demo.repository;

import com.hrant.demo.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository<Course> {

    private final JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(CourseRepositoryImpl.class);

    @Autowired
    public CourseRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseName(rs.getString("course_name"));
        course.setStartDate(rs.getString("start_date"));
        course.setEndDate(rs.getString("end_date"));
        course.setTeacherName(rs.getString("teacher_name"));
        course.setDescription(rs.getString("description"));
        return course;
    };

    @Override
    public List<Course> selectAllCourse() {

        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional<Course> selectCourseById(int id) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";

        Course course = null;

        try {
            course = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);

        } catch (DataAccessException ex) {
            log.info("Course not found: " + id);

        }

        return Optional.ofNullable(course);
    }

    @Override
    public int insertCourse(Course course) {
        String sql = "INSERT INTO courses(course_name, start_date, end_date, teacher_name, description) values (?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql, course.getCourseName(), course.getStartDate(), course.getEndDate(),
                course.getTeacherName(), course.getDescription());
        if (insert == 1) {
            log.info("New Course Created: " + course.getCourseName());
            return 0;
        }

        return 1;
    }

    @Override
    public int deleteCourseById(int id) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        int delete = jdbcTemplate.update(sql, id);
        if (delete == 1) {
            log.info("Course Deleted: " + id);
            return 0;
        }

        return 1;
    }

    @Override
    public int updateCourseById(Course course, int id) {
        String sql = "update courses set course_name = ?, start_date = ?, end_date = ?, teacher_name = ?, description = ? where course_id = ?";
        int update = jdbcTemplate.update(sql, course.getCourseName(), course.getStartDate(), course.getEndDate(),
                course.getTeacherName(), course.getDescription(), id);
        if (update == 1) {
            log.info("Course Updated: " + course.getCourseName());
            return 0;
        }

        return 1;
    }
}
