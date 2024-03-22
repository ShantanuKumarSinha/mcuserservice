package dev.shann.mcuserservice;

import dev.shann.mcuserservice.repository.UserRepository;
import dev.shann.mcuserservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class McuserserviceApplication {

	@Bean
	public UserService userService(UserRepository userRepository) {
    return new UserService(userRepository, new ModelMapper());
	}

	public static void main(String[] args) {
		SpringApplication.run(McuserserviceApplication.class, args);
	}

}
