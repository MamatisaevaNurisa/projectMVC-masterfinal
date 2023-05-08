package peaksoft.service;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void addCourse(Long companyId, Course course);
    Course getCourseById(Long courseId);
    void updateCourse(Long id, Course course, Long companyId);
    void deleteCourse(Course course);
}
