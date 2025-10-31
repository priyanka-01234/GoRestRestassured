 package com.ReqresRequest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import reqTestData.ReqUtility;

public class PostRequest {
	@Test
	public void postMethodReq() {
		given()
		.body(ReqUtility.reqPayload)	
		.headers(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(201);

	}
	@Test
	public void postMethodInvalidData() {
		given()
		.body(ReqUtility.invalidPayload)	
		.headers(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(201);

	}
	@Test
	public void postMethodwithInvalidKeyValue() {
		given()
		.body(ReqUtility.reqPayload)
		
		.headers(ReqUtility.apiKeyName,"reqres-free-v184690")
		.contentType(ContentType.JSON)
		.when()
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(403);

	}
	@Test
	public void postMethodwithInvalidValue() {
		given()
		.body(ReqUtility.reqPayload)	
		.headers("x-api-key3",ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(401);

	}
	@Test
	public void postMethodwithInvalidurl() {
		given()
		.body(ReqUtility.reqPayload)	
		.headers(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.com/api/users35")
		.then()
		.log()
		.all()
		.statusCode(404);

	}
	
	@Test
	public void postdatawithCalls() {
		given()
		.body(ReqUtility.reqPayload)
		.headers(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()		
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(201)
		.body("name", Matchers.equalTo("skillio"))
		.body("job", Matchers.equalTo("leader"))
		.body("id", Matchers.notNullValue())
		 .body("createdAt", Matchers.notNullValue());
		
		
	}
}
