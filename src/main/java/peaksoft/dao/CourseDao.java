package peaksoft.dao;

import peaksoft.entities.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAllCourses();
    void addCourse(Long companyId, Course course);
    Course getCourseById(Long courseId);
    void updateCourse(Long id, Course course, Long companyId);
    void deleteCourse(Course course);
}
