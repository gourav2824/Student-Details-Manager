package gourav.springboot.studentdetailsmanager.request;

import lombok.Getter;

@Getter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
}
