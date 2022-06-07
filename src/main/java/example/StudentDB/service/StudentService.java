package example.StudentDB.service;

import example.StudentDB.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> findAll();
    void deleteById(long id);
}
