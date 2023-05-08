package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Teacher;
import peaksoft.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public void addTeacher(Long courseId, Teacher teacher) {
        teacherDao.addTeacher(courseId, teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public void updateTeacher(Long id, Long courseId, Teacher teacher) {
        teacherDao.updateTeacher(id, courseId,  teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDao.deleteTeacher(teacher);
    }
}
