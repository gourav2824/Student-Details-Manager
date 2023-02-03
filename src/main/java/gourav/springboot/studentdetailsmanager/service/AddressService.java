package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.repository.AddressRepository;
import gourav.springboot.studentdetailsmanager.request.CreateAddressRequest;
import org.springframework.stereotype.Service;

@SuppressWarnings("ClassCanBeRecord")
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(CreateAddressRequest createAddressRequest) {
        final Address address = new Address(createAddressRequest.getStreet(), createAddressRequest.getCity());
        return addressRepository.save(address);
    }

    public Address getAddress(int addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }
}
