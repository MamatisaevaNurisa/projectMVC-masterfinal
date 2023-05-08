package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.entities.Course;
import peaksoft.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void addCourse(Long companyId, Course course) {
        courseDao.addCourse(companyId, course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public void updateCourse(Long id, Course course, Long companyId) {
        courseDao.updateCourse(id, course, companyId);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }
}
