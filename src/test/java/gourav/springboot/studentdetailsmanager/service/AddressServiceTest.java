package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.repository.AddressRepository;
import gourav.springboot.studentdetailsmanager.request.CreateAddressRequest;
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
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    private AddressService addressService;

    @BeforeEach
    void setUp() {
        addressService = new AddressService(addressRepository);
    }

    @Test
    void shouldBeAbleToCreateAddress() {
        final Address address = new Address("New Street", "New Delhi");
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        final CreateAddressRequest createAddressRequest = new CreateAddressRequest(address.getStreet(), address.getCity());

        final Address actualAddress = addressService.createAddress(createAddressRequest);

        assertThat(actualAddress.getId()).isNull();
        assertThat(actualAddress.getStreet()).isEqualTo(createAddressRequest.getStreet());
        assertThat(actualAddress.getCity()).isEqualTo(createAddressRequest.getCity());
    }

    @Test
    void shouldBeAbleToGetAddress() {
        final int addressId = 1;
        final Address address = new Address("New Street", "New Delhi");
        when(addressRepository.findById(addressId)).thenReturn(Optional.of(address));

        final Address actualAddress = addressService.getAddress(addressId);

        assertThat(actualAddress.getStreet()).isEqualTo(address.getStreet());
        assertThat(actualAddress.getCity()).isEqualTo(address.getCity());
    }
}
