package in.pwskill.deepesh.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.pwskill.deepesh.response.Cart;


@FeignClient("CART-SERVICE")
public interface ICartConsumer {
	
	@GetMapping("/v1/api/cart/show")
	public ResponseEntity<String> getProduct();
	
    @GetMapping("/v1/api/cart/order/{id}")
    ResponseEntity<Cart> getOrder(@PathVariable Integer id);
    
    @PostMapping("/v1/api/cart/products/item")
    ResponseEntity<String> enterOrder(@RequestBody Cart cart);

}
