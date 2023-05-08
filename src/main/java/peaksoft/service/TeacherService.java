package peaksoft.service;

import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    void addTeacher(Long courseId, Teacher teacher);
    Teacher getTeacherById(Long id);
    void updateTeacher(Long id, Long courseId, Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
