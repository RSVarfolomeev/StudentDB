package example.StudentDB.service;

import example.StudentDB.entity.Student;
import example.StudentDB.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    Добавление в таблицу тестовых данных
    @PostConstruct
    public void generateTestData() {
        save(new Student(1L,"Иван", "Иванович", "Иванов",
                LocalDate.of(2000, 1, 22), "ТЛТ-411"));
        save(new Student(2L,"Петр", "Петрович", "Петров",
                LocalDate.of(1999, 11, 30), "ТЛТ-412"));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }
}
