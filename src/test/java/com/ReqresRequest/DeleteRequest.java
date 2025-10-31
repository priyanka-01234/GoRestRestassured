package com.ReqresRequest;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import reqTestData.ReqUtility;

public class DeleteRequest {
	
	@Test
	public void deleteData() {
		given()
		.header(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.when()
		.delete(ReqUtility.baseURL+"/2")
		.then()
		.log()
		.all()
		.statusCode(204);		
	}
	
	@Test
	public void deleteDataWithInvalidKey() {
		given()
		.header("x-api-key1","reqres-free-v145")
		.when()
		.delete(ReqUtility.baseURL+"/8")
		.then()
		.log()
		.all()
		.statusCode(401);
	}
	@Test
	public void deleteDataWithInvalidMethod() {
		given()
		.header("x-api-key1","reqres-free-v145")
		.when()
		.post(ReqUtility.baseURL+"/2")
		.then()
		.log()
		.all()
		.statusCode(415);
	}
	
	@Test
	public void deleteDataWithInvalidURL() {
		given()
		.header("x-api-key1","reqres-free-v145")
		.when()
		.post(ReqUtility.baseURL+"/8")
		.then()
		.log()
		.all()
		.statusCode(415);
	}


}
