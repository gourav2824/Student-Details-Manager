package gourav.springboot.studentdetailsmanager.controller;

import gourav.springboot.studentdetailsmanager.response.StudentResponse;
import gourav.springboot.studentdetailsmanager.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public StudentResponse getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }
}
