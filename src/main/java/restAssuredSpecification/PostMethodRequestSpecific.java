package restAssuredSpecification;

import org.apache.commons.lang3.RandomStringUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PostMethodRequestSpecific {
	static RequestSpecBuilder builder = new RequestSpecBuilder();
	public static String randomString =RandomStringUtils.randomAlphanumeric(10);
	static String email = randomString+"@gmail.com";
	static String authValue = "Bearer 873b48a3475c39b6964834321617b282d8b69317eb1a09e04b22cb152417c694";
	public static String baseUrl = "https://gorest.co.in/public/v2/users";
	static String randomNumber = RandomStringUtils.randomNumeric(7);
	static String userId = randomNumber;
	
	
	public static RequestSpecification validPostMethodRequest() {
		builder.setBody("{\r\n" 
		        + "    \"id\": 8208133,\r\n" 
				+ "    \"name\": \""+randomString+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n" 
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n" + "  }");
		builder.addHeader("Authorization", authValue);
		builder.setContentType(ContentType.JSON);
		builder.setBaseUri(baseUrl);
		RequestSpecification reqSpec = builder.build();
		return reqSpec;
	
	}
	
	public RequestSpecification validPatchmethod() {
		builder.setBody("\"id\": 8208131,\r\n"
				+ "    \"name\": \""+randomString+"\",\r\n"
				+ "    \"email\": \""+email+"\",\r\n"
				+ "    \"gender\": \"female\",\r\n"
				+ "    \"status\": \"inactive");
		builder.addHeader("Authorization", authValue);
		builder.setContentType(ContentType.JSON);
		builder.setBaseUri(baseUrl+"/+8208128");
		//Interface
		RequestSpecification reqSpec = builder.build();
		return reqSpec;
	}
}
