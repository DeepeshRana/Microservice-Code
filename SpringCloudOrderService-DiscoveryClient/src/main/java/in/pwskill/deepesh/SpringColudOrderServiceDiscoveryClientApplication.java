package in.pwskill.deepesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringColudOrderServiceDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringColudOrderServiceDiscoveryClientApplication.class, args);
	}

}
