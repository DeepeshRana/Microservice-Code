package in.pwskills.deepesh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StockInfo {
	private Integer stkId;
	private String stkCode;
	private Double stkCost;
}
