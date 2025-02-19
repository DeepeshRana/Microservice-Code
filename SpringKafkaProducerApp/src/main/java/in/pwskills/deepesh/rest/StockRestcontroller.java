package in.pwskills.deepesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.deepesh.converter.JsonUtil;
import in.pwskills.deepesh.entity.StockInfo;
import in.pwskills.deepesh.producer.ProducerService;

@RestController
@RequestMapping("/v1/api/stock")
public class StockRestcontroller {

	@Autowired
	private ProducerService producerService;

	@GetMapping("/send")
	public String readInput(@RequestParam Double cost, @RequestParam String code) {

		// Store Object
		StockInfo info = new StockInfo();
		info.setStkCode(code);
		info.setStkCost(cost);

		// Convert to JSON

		String out = JsonUtil.convertJson(info);

		if (out != null) {
			producerService.sendMessage(out);
			return "SUCESS";
		} else {
			return "FAILUER";
		}

	}

}
