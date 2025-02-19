package in.pwskill.deepesh.test;

import java.sql.DatabaseMetaData;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.pwskill.deepesh.service.ProducerSearvice;

@Component
public class ProducerTest {
	
	@Autowired
	private ProducerSearvice producerSearvice;
	
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() {
		producerSearvice.sendData("Hell :" + new Date());
		System.out.println("PRODUCER SEND MESSAGE.....");
	}
}
