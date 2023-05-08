package peaksoft.dao;

import org.springframework.ui.context.Theme;
import peaksoft.entities.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeachers();
    void addTeacher(Long courseId, Teacher teacher);
    Teacher getTeacherById(Long id);
    void updateTeacher(Long id, Long courseId, Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
