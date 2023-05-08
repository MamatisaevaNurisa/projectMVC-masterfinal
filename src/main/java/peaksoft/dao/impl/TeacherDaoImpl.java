package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.TeacherDao;
import peaksoft.entities.Course;
import peaksoft.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = manager.createQuery("From Teacher", Teacher.class).getResultList();
        return teachers;
    }

    @Override
    public void addTeacher(Long courseId, Teacher teacher) {
        Course course = manager.find(Course.class, courseId);
        teacher.setCourse(course);
        manager.persist(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher = manager.find(Teacher.class, id);
        return teacher;
    }

    @Override
    public void updateTeacher(Long id, Long courseId, Teacher teacher) {
        Course course = manager.find(Course.class, courseId);
        Teacher teacher1 = getTeacherById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setCourse(course);
        manager.merge(teacher1);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
    manager.remove(manager.contains(teacher)? teacher : manager.merge(teacher));
    }
}
