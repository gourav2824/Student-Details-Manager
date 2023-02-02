package gourav.springboot.studentdetailsmanager.repository;

import gourav.springboot.studentdetailsmanager.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
