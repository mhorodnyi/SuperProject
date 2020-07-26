package super_project.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String nickname;
	private String password;
	@DBRef
	private Address address;
	@DBRef
	private Contacts contacts;
	
}
