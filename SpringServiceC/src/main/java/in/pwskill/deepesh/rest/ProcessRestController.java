package in.pwskill.deepesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/api/C")
public class ProcessRestController {
	
	@GetMapping("/showC")
	public String showMsg() {		
		return "From C : ";
	}
}
