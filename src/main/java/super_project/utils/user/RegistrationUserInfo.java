package super_project.utils.user;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import super_project.utils.Address;
import super_project.utils.ContactsObject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationUserInfo {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String nickname;
	private String password;
	private Address address;
	private ContactsObject contacts;
}
