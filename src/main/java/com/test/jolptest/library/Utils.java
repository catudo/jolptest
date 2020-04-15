package com.test.jolptest.library;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class Utils {
	
	public static Object transform(String spectFile,String jsonObject) {
		List<Object> listSpect = JsonUtils.classpathToList( spectFile);
		Chainr chainr = Chainr.fromSpec(listSpect);
        Object inputJsonObject = JsonUtils.jsonToObject(jsonObject);
        Object transformedOutput = chainr.transform(inputJsonObject);
		return new ResponseEntity<>(transformedOutput, HttpStatus.OK);
		
	}
	
	
	public static String getDataFromUrl(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result; 	
	}

}
