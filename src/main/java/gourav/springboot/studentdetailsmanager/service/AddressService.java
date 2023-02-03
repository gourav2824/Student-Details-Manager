package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.repository.AddressRepository;
import org.springframework.stereotype.Service;

@SuppressWarnings("ClassCanBeRecord")
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddress(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
}
