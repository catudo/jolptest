package com.test.jolptest.controller;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.test.jolptest.domain.ResultData;
import com.test.jolptest.library.Utils;
/**
JSON EXAMPLE
* 
* {
  "data": {
    "coordinates": {
      "latitude": 4,
      "longitude": -72
    },
    "name": "Colombia",
    "code": "CO",
    "population": 47790000,
    "updated_at": "2020-04-15T15:03:51.618Z",
    "today": {
      "deaths": 0,
      "confirmed": 0
    },
    "latest_data": {
      "deaths": 127,
      "confirmed": 2979,
      "recovered": 354,
      "critical": 106,
      "calculated": {
        "death_rate": 4.263175562269217,
        "recovery_rate": 11.88318227593152,
        "recovered_vs_death_ratio": null,
        "cases_per_million_population": 59
      }
    },
    "timeline": [
      {
        "updated_at": "2020-04-15T14:58:59.122Z",
        "date": "2020-04-15",
        "deaths": 127,
        "confirmed": 2979,
        "active": 2498,
        "recovered": 354,
        "new_confirmed": 0,
        "new_recovered": 0,
        "new_deaths": 0,
        "is_in_progress": true
      },
      {
        "updated_at": "2020-04-14T21:33:12.000Z",
        "date": "2020-04-14",
        "deaths": 127,
        "confirmed": 2979,
        "recovered": 354,
        "new_confirmed": 127,
        "new_recovered": 35,
        "new_deaths": 15,
        "active": 2498
      }
    ]
  },
  "_cacheHit": true
}
	 
 */



@RestController
public class JolpCasesController {
	
	
	private final String API_URL = "https://corona-api.com/countries/CO";

	@GetMapping(value = "/get-data")
	public ResponseEntity<ResultData> getData() {
		RestTemplate restTemplate = new RestTemplate();
		ResultData result = restTemplate.getForObject("https://corona-api.com/countries/CO", ResultData.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * Transform the json according to shift.json specification, this one is in src/main/resources/shift.json
	 * @return ResponseEntity
	 * @throws URISyntaxException
	 */
	
	@GetMapping(value = "/shift")
	public ResponseEntity<Object> shift() throws URISyntaxException {
		String result = Utils.getDataFromUrl(API_URL);
		Object transformedOutput = Utils.transform("/specs/shift.json", result);
		return new ResponseEntity<>(transformedOutput, HttpStatus.OK);
	}
	
	/**
	 * Transform the json according to shift.json specification, this one is in src/main/resources/shift.json
	 * @return ResponseEntity
	 * @throws URISyntaxException
	 */
	
	@GetMapping(value = "/remove")
	public ResponseEntity<Object> remove() throws URISyntaxException {
		String result = Utils.getDataFromUrl(API_URL);
		Object transformedOutput = Utils.transform("/specs/delete.json", result);
		return new ResponseEntity<>(transformedOutput, HttpStatus.OK);
		
	}
	
	/**
	 * Transform the json according to shift.json specification, this one is in src/main/resources/transpose.json
	 * @return ResponseEntity
	 * @throws URISyntaxException
	 */
	@GetMapping(value = "/transpose")
	public ResponseEntity<Object> cardinalty() throws URISyntaxException {
		String result = Utils.getDataFromUrl(API_URL);
		Object transformedOutput = Utils.transform("/specs/transpose.json", result);
		return new ResponseEntity<>(transformedOutput, HttpStatus.OK);
		
	}

}
