package in.pwskill.deepesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/api/B")
public class ProcessRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/showB")
	public String showMsg() {
		String resp = restTemplate.getForEntity("http://localhost:8085/v1/api/C/showC", String.class).getBody();
		
		return "From B : " + resp;
	}
}
