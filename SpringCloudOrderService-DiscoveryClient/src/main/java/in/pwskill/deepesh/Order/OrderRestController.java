package in.pwskill.deepesh.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import in.pwskill.deepesh.consumer.CartConsumer;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {
	
	/*
	 * Method 	: get
	 * path 	: /place
	 * output 	: R.T<String>
	 * url 		: v1/api/order/place
	 * 
	 */
	
	@Autowired
	private CartConsumer cartConsumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> getProduct(){
		
		String cartResponce = cartConsumer.getCartService();
		return ResponseEntity.ok("ORDER PLACE WITH => " + cartResponce);
	}

}
