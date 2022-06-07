package example.StudentDB.controller;

import example.StudentDB.entity.Student;
import example.StudentDB.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    //    http://localhost:8080/v1/students
    @GetMapping
    public String index(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);
        return "index";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam(name = "id") Long id) {
        studentService.deleteById(id);
        return "redirect:/v1/students";
    }

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student) {
        if (student.getFirstName().equals("") || student.getFirstName() == null
                || student.getMiddleName().equals("") || student.getMiddleName() == null
                || student.getLastName().equals("") || student.getLastName() == null
                || student.getBirthDate() == null
                || student.getGroup().equals("") || student.getGroup() == null) {
            return "redirect:/v1/students";
        } else {
            studentService.save(student);
            return "redirect:/v1/students";
        }
    }
}