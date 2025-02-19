package in.pwskill.deepesh.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@GetMapping("/item")
	public ResponseEntity<String> createOrder() {
		return new ResponseEntity<String>("Hello User !", HttpStatus.OK);
	}

}
