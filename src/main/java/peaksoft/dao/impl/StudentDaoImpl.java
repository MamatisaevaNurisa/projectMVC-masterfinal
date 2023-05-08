package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Group;
import peaksoft.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = manager.createQuery("From Student", Student.class).getResultList();
        return students;
    }

    @Override
    public void addStudent(Long groupId, Student student) {
        Group group = manager.find(Group.class, groupId);
        student.setGroup(group);
        manager.persist(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = manager.find(Student.class, id);
        return student;
    }

    @Override
    public void updateStudent(Long id, Student student, Long groupId) {
        Group group = manager.find(Group.class, groupId);
        Student student1 = getStudentById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setStudyFormation(student.getStudyFormation());
        List<Student> students = new ArrayList<>();
        students.add(student1);
        group.setStudents(students);
        student1.setGroup(group);
        manager.merge(student1);
    }

    @Override
    public void deleteStudent(Student student) {
        manager.remove(manager.contains(student) ? student : manager.merge(student));
    }

    @Override
    public List<Student> getStudentsByCompany(Long companyId) {
        List<Student> students = manager.createQuery("select s from Student s join Group g ON s.group.id = g.id join g.courses c join Company com ON c.company.id = com.id where com.id=?1",
                Student.class).setParameter(1, companyId).getResultList();
        return students;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        List<Student> students = manager.createQuery("select s from Student s where s.firstName=?1")
                .setParameter(1,name).getResultList();
        return students;
    }

    @Override
    public List<Student> getStudentsByTeacher(Long teacherId) {
        List<Student> students = manager.createQuery("select s from Student s join Group g ON s.group.id = g.id join g.courses c join Teacher t ON c.teacher.id = t.id where t.id=?1",
                Student.class).setParameter(1, teacherId).getResultList();
        return students;
    }

}
