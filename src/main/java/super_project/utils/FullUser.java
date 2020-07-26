package super_project.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullUser {
	private String id;
	private String firstName;
	private String lastName;
	private String nickname;
	private Address address;
	private Contacts contacts;
}
