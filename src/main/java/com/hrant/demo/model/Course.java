package com.hrant.demo.model;

public class Course {


    private int courseId;

    private String courseName;

    private String startDate;

    private String endDate;

    private String teacherName;

    private String description;

    public Course() {
    }

    public Course(String courseName, String startDate, String endDate, String teacherName, String description) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherName = teacherName;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
