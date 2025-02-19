package in.pwskill.deepesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringConsumerApp1Mq1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerApp1Mq1Application.class, args);
	}

}
