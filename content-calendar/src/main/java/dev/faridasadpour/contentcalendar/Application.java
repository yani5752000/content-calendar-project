package dev.faridasadpour.contentcalendar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		System.out.println(restTemplate);
	}

	@Bean
	CommandLineRunner commandLineRunner(JdbcConnectionDetails jdbc) {
		return args -> {
			var details = "JDBC URL:";
					

			System.out.println("Class: ");
			System.out.println(jdbc.getClass().getName().toString());
			System.out.println("username: ");
			System.out.println(jdbc.getUsername().toString());
			System.out.println("password: ");
			System.out.println(jdbc.getPassword().toString());
			System.out.println("jdbc url: ");
			System.out.println(jdbc.getJdbcUrl().toString());
		};

		
	}

}
