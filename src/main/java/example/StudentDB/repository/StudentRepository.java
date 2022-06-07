package example.StudentDB.repository;


import example.StudentDB.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student save(Student student);
    List<Student> findAll();
    void deleteById(long id);
}
