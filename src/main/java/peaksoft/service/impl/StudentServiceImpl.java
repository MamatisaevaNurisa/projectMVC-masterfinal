package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entities.Student;
import peaksoft.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void addStudent(Long groupId, Student student) {
        studentDao.addStudent(groupId, student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Long id, Student student, Long groupId) {
        studentDao.updateStudent(id, student, groupId);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.deleteStudent(student);
    }

    @Override
    public List<Student> getStudentsByCompany(Long companyId) {
        return studentDao.getStudentsByCompany(companyId);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentDao.getStudentByName(name);
    }

    @Override
    public List<Student> getStudentsByTeacher(Long teacherId) {
        return studentDao.getStudentsByTeacher(teacherId);
    }
}
