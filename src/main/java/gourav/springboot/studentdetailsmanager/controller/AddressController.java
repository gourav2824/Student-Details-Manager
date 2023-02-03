package gourav.springboot.studentdetailsmanager.controller;

import gourav.springboot.studentdetailsmanager.model.Address;
import gourav.springboot.studentdetailsmanager.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressService.getAddress(id);
    }
}
