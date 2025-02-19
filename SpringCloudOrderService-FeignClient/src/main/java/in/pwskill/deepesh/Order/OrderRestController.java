package in.pwskill.deepesh.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskill.deepesh.consumer.ICartConsumer;
import in.pwskill.deepesh.response.Cart;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {

	/*
	 * Method : get path : /place output : R.T<String> url : v1/api/order/place
	 * 
	 */

	@Autowired
	private ICartConsumer iCartConsumer;

	@GetMapping("/place")
	public ResponseEntity<String> getProduct() {

		String cartResponce = iCartConsumer.getProduct().getBody();
		return ResponseEntity.ok("ORDER PLACE WITH => " + cartResponce);
	}

	/**
	 * Method : fetchCart Path : /v1/api/order/cart/{id} Output :
	 * ResponseEntity<Cart> URL : v1/api/order/cart/{id} Description: This method
	 * fetches the cart details for a given ID.
	 */
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> fetchCart(@PathVariable int id) {
		Cart order = iCartConsumer.getOrder(id).getBody();
		return ResponseEntity.ok(order);
	
	
	}
	
	@PostMapping(value = "/product/item")
	public ResponseEntity<String> createCart(@RequestBody Cart cart) {
		String output = iCartConsumer.enterOrder(cart).getBody();
		return ResponseEntity.ok("New product add in cart : " + output);
	}

}
