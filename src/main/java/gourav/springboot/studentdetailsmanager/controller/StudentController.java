package gourav.springboot.studentdetailsmanager.controller;

import gourav.springboot.studentdetailsmanager.request.CreateStudentRequest;
import gourav.springboot.studentdetailsmanager.response.StudentResponse;
import gourav.springboot.studentdetailsmanager.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }
}
