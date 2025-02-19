package in.pwskills.deepesh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.deepesh.entity.StockInfo;
import in.pwskills.deepesh.repository.IStockReposiroty;

@RestController
@RequestMapping("/v1/api/stock")
public class StockRestController {

	@Autowired
	private IStockReposiroty iStockReposiroty;

	@GetMapping("/all")
	public List<StockInfo> findAllStocks() {
		return iStockReposiroty.findAll();
	}
}
