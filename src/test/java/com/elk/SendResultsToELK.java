/**
 * 
 */
package com.elk;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.enums.ConfigPropertiesEnum;
import com.utils.PropertiesUtils;

/**
 * Jul 3, 2021
 * 
 * @author Krishanu
 */
public class SendResultsToELK {

	/**
	 * Jul 3, 2021
	 * 
	 * @author Krishanu
	 * @param args
	 */
	public static void main(String[] args) {

		String baseURI = PropertiesUtils.get(ConfigPropertiesEnum.ELASTICSEARCHURL);
		
		Map<String, String> reqMap = new HashMap<>();
		reqMap.put("testName", "TC2");
		reqMap.put("status", "fail");
		reqMap.put("executionTime", LocalDate.now().toString());

		given()
		    .header("Content-Type", "application/json")
		    .body(reqMap)
		    .log().all()
		.when()
		    .post(baseURI);

	}

}
