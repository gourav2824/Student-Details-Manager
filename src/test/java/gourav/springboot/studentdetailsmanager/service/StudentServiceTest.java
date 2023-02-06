package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.model.Student;
import gourav.springboot.studentdetailsmanager.repository.StudentRepository;
import gourav.springboot.studentdetailsmanager.request.CreateAddressRequest;
import gourav.springboot.studentdetailsmanager.request.CreateStudentRequest;
import gourav.springboot.studentdetailsmanager.response.StudentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    private static final int STUDENT_ID = 1;
    private static final int ADDRESS_ID = 10;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private AddressService addressService;

    private StudentService studentService;
    private Student student;
    private Address address;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository, addressService);
        address = new Address("New Street", "New York");
        address.setId(ADDRESS_ID);
        student = new Student("John", "Wick", "john.wick@mail.com", ADDRESS_ID);
        student.setId(STUDENT_ID);
    }

    @Test
    void testGetStudent() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(student));
        when(addressService.getAddress(ADDRESS_ID)).thenReturn(address);

        final StudentResponse studentResponse = studentService.getStudent(STUDENT_ID);

        assertStudentResponse(studentResponse);
    }

    @Test
    void testCreateStudent() {
        when(addressService.createAddress(any(CreateAddressRequest.class))).thenReturn(address);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        final StudentResponse studentResponse = studentService.createStudent(new CreateStudentRequest());

        assertStudentResponse(studentResponse);
    }

    private void assertStudentResponse(StudentResponse studentResponse) {
        assertThat(studentResponse.getId()).isEqualTo(STUDENT_ID);
        assertThat(studentResponse.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(studentResponse.getLastName()).isEqualTo(student.getLastName());
        assertThat(studentResponse.getEmail()).isEqualTo(student.getEmail());
        assertThat(studentResponse.getStreet()).isEqualTo(address.getStreet());
        assertThat(studentResponse.getCity()).isEqualTo(address.getCity());
    }
}
