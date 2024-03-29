package gourav.springboot.studentdetailsmanager.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
}
