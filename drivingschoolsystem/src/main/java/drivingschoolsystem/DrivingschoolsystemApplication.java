package drivingschoolsystem;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ch.qos.logback.classic.Logger;

@SpringBootApplication(scanBasePackages = "drivingschoolsystem")
@ComponentScan(basePackages = "drivingschoolsystem")
public class DrivingschoolsystemApplication {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(DrivingschoolsystemApplication.class);
	public static void main(String[] args) {
		logger.info("🚀 Starting Driving School System...");
		SpringApplication.run(DrivingschoolsystemApplication.class, args);
	}

}