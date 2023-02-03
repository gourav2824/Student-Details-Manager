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

    public Address createAddress(String street, String city) {
        final Address address = new Address(street, city);
        return addressRepository.save(address);
    }

    public Address getAddress(int addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }
}
