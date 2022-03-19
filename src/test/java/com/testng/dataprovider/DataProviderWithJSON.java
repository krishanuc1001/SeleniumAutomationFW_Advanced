package com.testng.dataprovider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviderWithJSON {

	@Test(dataProvider = "getData")
	public void testWithJSON(Map<String, Object> map) {

		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " : " + entry.getValue());
			System.out.println();
		}

		// map.forEach((k, v) -> System.out.println(k + ":" + v));

	}

	@DataProvider
	public Object[] getData() throws JsonParseException, JsonMappingException, IOException {

		HashMap<String, Object> map1 = new ObjectMapper().readValue(
				new File(System.getProperty("user.dir") + "/src/test/resources/jsons/config1.json"),
				new TypeReference<HashMap<String, Object>>() {
				});

		HashMap<String, Object> map2 = new ObjectMapper().readValue(
				new File(System.getProperty("user.dir") + "/src/test/resources/jsons/config2.json"),
				new TypeReference<HashMap<String, Object>>() {
				});

		return new Object[] { map1, map2 };

	}

}
