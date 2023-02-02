package gourav.springboot.studentdetailsmanager.repository;

import gourav.springboot.studentdetailsmanager.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
