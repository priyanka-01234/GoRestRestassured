package com.ReqresRequest;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import reqTestData.ReqUtility;

public class EndToEndPostMethodReq {
	
	@Test
	public void createUserWithValidPostRequest() {
		given()
		.body(ReqUtility.invalidPayload)	
		.headers(ReqUtility.apiKeyName,ReqUtility.apiKeyValue)
		.contentType(ContentType.JSON)
		.when()
		.post(ReqUtility.baseURL)
		.then()
		.log()
		.all()
		.statusCode(201)
		.body("name", Matchers.equalTo("Skillio")) //payload ka parameter check krna hai
		.body("job", Matchers.equalTo("leader"))
		.body("id", Matchers.notNullValue())
		.body("createdAt",Matchers.notNullValue());

		
	}

}
