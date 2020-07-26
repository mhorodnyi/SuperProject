package super_project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import super_project.db.cascades.UserCascade;

@Configuration
public class MongoConfigs {
	@Bean
	public UserCascade userCascade() {
	    return new UserCascade();
	}
}
