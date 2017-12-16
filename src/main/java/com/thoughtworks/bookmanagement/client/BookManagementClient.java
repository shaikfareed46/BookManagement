/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.client;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Shaik Fareed
 *
 */
@Component
public class BookManagementClient {
	
	@Value("${bookdetails.url}")
	private String url;

	/**
	 * @return
	 */
	public boolean isBookAvailable(String bookId) {
		

		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( "https://"+url+bookId, request , String.class );
		
		JSONParser jsonParser =  new JSONParser();
		
		String jsonResponse = response.getBody();
		
		try {
			Object obj = jsonParser.parse(jsonResponse);
			
			JSONObject jsonObject = (JSONObject) obj;
			
			boolean isAvailable = (Boolean) jsonObject.get("isAvailable");
			
			return isAvailable;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//String accessToken = (String) jsonObject.get("access_token");
		
		
		
		
		return false;
	}
	


}
