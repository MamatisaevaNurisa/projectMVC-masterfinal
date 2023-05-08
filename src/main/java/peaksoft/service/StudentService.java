package peaksoft.service;

import peaksoft.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Long groupId, Student student);
    Student getStudentById(Long id);
    void updateStudent(Long id, Student student, Long groupId);
    void deleteStudent(Student student);

    List<Student> getStudentsByCompany(Long companyId);
    List<Student> getStudentByName(String name);
    List<Student> getStudentsByTeacher(Long teacherId);
}
