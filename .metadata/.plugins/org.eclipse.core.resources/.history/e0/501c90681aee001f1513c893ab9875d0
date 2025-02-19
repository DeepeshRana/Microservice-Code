package in.pwskill.deepesh.rest;

import java.lang.module.ModuleDescriptor.Requires;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.pwskill.deepesh.response.Cart;


@RestController
@RequestMapping("/v1/api/cart")
@RefreshScope
public class CartServiceController {
	
	@Value("${server.port}")
	private String portNo;
	
	@Value("${my.app.title}")
	private String info;
	
	/*
	 * Method 	: get
	 * path 	: /show
	 * output 	: R.T<String>
	 * url 		: v1/api/cart/show
	 */
	@RequestMapping(value = "/show" ,method = RequestMethod.GET)
	public ResponseEntity<String> getProduct(
			@RequestHeader("TOKENID") String tokenInfo
			){
		return ResponseEntity.ok("GETTING OUTPUT FROM MS#1 THROUGH EUREKA SERVER... " + portNo 
																					  + " and data retrive from "+ info
																					  + " and Prifilter data " + tokenInfo);
	}
	
	/**
     * Method   : getOrder
     * Path     : /v1/api/cart/order/{id}
     * Output   : ResponseEntity<Cart>
     * Description: This method returns a sample cart item based on the given order ID.
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cart> getOrder(@PathVariable Integer id) {
        Cart cart = new Cart();
        cart.setId(id);
        cart.setProductName("Chocolate");
        cart.setProductPrice(20.25f);
        cart.setProductRating(2.2f);

        return ResponseEntity.ok(cart);
    }

    /**
     * Method   : enterOrder
     * Path     : /v1/api/cart/products/item
     * Output   : ResponseEntity<String>
     * Description: This method accepts a cart object in the request body and returns a confirmation message.
     */
    @RequestMapping(value = "/products/item", method = RequestMethod.POST)
    public ResponseEntity<String> enterOrder(@RequestBody Cart cart) {
        return ResponseEntity.ok("Order item received: " + cart + "with port no "+ portNo);
    }
	
}
