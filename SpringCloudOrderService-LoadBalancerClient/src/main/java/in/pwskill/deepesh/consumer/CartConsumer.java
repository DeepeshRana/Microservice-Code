package in.pwskill.deepesh.consumer;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CartConsumer {
	
	@Autowired
	private LoadBalancerClient client;

	// write the logic to consume to other service

	public String getCartService() {
		
		
		ServiceInstance choose = client.choose("CART-SERVICE");
		
		URI uri = choose.getUri();
		
		String url = uri + "/v1/api/cart/show";
		
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
		return forEntity.getBody();
	}

}
