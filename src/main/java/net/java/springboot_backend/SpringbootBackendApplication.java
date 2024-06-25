package net.java.springboot_backend;

import net.java.springboot_backend.model.Employee;
import net.java.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);

	}
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
 Employee employee = new Employee();
 employee.setFirstName("Yeturi");
 employee.setLastName("Latha");
 employee.setEmailId("yeturi@gmail.com");
 employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Yeturi");
		employee1.setLastName("kavya");
		employee1.setEmailId("kavya@gmail.com");
		employeeRepository.save(employee1);
	}
}
