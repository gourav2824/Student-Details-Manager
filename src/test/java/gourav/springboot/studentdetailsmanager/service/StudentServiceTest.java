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

    @Mock
    private Student student;
    @Mock
    private Address address;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private AddressService addressService;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository, addressService);
    }

    @Test
    void shouldBeAbleToGetStudent() {
        final int studentId = 1, addressId = 10;
        when(student.getId()).thenReturn(studentId);
        when(student.getAddressId()).thenReturn(addressId);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(addressService.getAddress(addressId)).thenReturn(address);

        final StudentResponse studentResponse = studentService.getStudent(studentId);

        assertThat(studentResponse.getId()).isEqualTo(studentId);
    }

    @Test
    void shouldBeAbleToCreateStudent() {
        final int studentId = 1;
        when(student.getId()).thenReturn(studentId);
        when(addressService.createAddress(any(CreateAddressRequest.class))).thenReturn(address);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        final StudentResponse studentResponse = studentService.createStudent(new CreateStudentRequest());

        assertThat(studentResponse.getId()).isEqualTo(studentId);
    }
}
