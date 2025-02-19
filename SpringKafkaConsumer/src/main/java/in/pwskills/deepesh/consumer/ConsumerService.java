package in.pwskills.deepesh.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import in.pwskills.deepesh.converter.JsonUtil;
import in.pwskills.deepesh.entity.StockInfo;
import in.pwskills.deepesh.repository.IStockReposiroty;

@Component
public class ConsumerService {
	
	@Autowired
	private IStockReposiroty reposiroty;
	
	@KafkaListener(topics = "${my.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void readData(String message) {
				
		//used message for internal storage
		System.out.println("******Consumer reading data**********");
		System.out.println(message);
		
		StockInfo responce = JsonUtil.convertJsontoObject(message);
		
		
		reposiroty.save(responce);
		
		
		
	}

}
