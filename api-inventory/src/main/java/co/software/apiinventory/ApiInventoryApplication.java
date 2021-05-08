package co.software.apiinventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiInventoryApplication.class, args);
	}

}
