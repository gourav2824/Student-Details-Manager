package gourav.springboot.studentdetailsmanager.service;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.repository.AddressRepository;
import gourav.springboot.studentdetailsmanager.request.CreateAddressRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Test
    void shouldBeAbleToCreateAddress() {
        final Address address = new Address("New Street", "New Delhi");
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        final AddressService addressService = new AddressService(addressRepository);
        final CreateAddressRequest createAddressRequest = new CreateAddressRequest(address.getStreet(), address.getCity());

        final Address actualAddress = addressService.createAddress(createAddressRequest);

        assertThat(actualAddress.getId()).isNull();
        assertThat(actualAddress.getStreet()).isEqualTo(createAddressRequest.getStreet());
        assertThat(actualAddress.getCity()).isEqualTo(createAddressRequest.getCity());
    }
}
