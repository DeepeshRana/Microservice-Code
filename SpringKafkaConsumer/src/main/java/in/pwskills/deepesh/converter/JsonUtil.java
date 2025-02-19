package in.pwskills.deepesh.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.deepesh.entity.StockInfo;

public class JsonUtil {
	
	public static StockInfo convertJsontoObject(String message) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(message , StockInfo.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
