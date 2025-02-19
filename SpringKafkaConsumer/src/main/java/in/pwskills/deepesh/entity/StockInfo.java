package in.pwskills.deepesh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "STOCK")
public class StockInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stkId;
	private String stkCode;
	private Double stkCost;
}
