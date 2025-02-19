package in.pwskills.deepesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pwskills.deepesh.entity.StockInfo;

@Repository
public interface IStockReposiroty extends JpaRepository<StockInfo, Integer> {

}
