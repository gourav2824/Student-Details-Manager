package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.model.Student;
import gourav.springboot.studentdetailsmanager.repository.StudentRepository;
import gourav.springboot.studentdetailsmanager.request.CreateAddressRequest;
import gourav.springboot.studentdetailsmanager.request.CreateStudentRequest;
import gourav.springboot.studentdetailsmanager.response.StudentResponse;
import org.springframework.stereotype.Service;

@SuppressWarnings("ClassCanBeRecord")
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressService addressService;

    public StudentService(StudentRepository studentRepository, AddressService addressService) {
        this.studentRepository = studentRepository;
        this.addressService = addressService;
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        final Address address = addressService.createAddress(
                new CreateAddressRequest(createStudentRequest.getStreet(), createStudentRequest.getCity()));

        Student student = new Student(
                createStudentRequest.getFirstName(),
                createStudentRequest.getLastName(),
                createStudentRequest.getEmail(),
                address.getId()
        );
        student = studentRepository.save(student);

        return getStudentResponse(student, address);
    }

    public StudentResponse getStudent(int studentId) {
        final Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        final Address address = addressService.getAddress(student.getAddressId());
        return getStudentResponse(student, address);
    }

    private StudentResponse getStudentResponse(Student student, Address address) {
        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                address.getStreet(),
                address.getCity()
        );
    }
}
