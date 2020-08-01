package super_project.utils.user;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMainInfo {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String nickname;
}
