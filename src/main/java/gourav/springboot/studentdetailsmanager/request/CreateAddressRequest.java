package gourav.springboot.studentdetailsmanager.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAddressRequest {
    private String street;
    private String city;
}
