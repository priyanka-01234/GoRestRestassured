package com.ReqresRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import reqTestData.ReqUtility;

import static io.restassured.RestAssured.*;

public class GetRequest {

	@Test
	public void getValidRequest() {
		given()
		.when()
		.get(ReqUtility.baseURL+"?page=2")
		.then()
		.log().all();
	}

	@Test
	public void getDataOfFirstPage() {
		given()
		.when()
		.get(ReqUtility.baseURL+"?page=1")
		.then()
		.log().all();

	}
	
	@Test
	public void getDataOfFifthPage() {
		given()
		.header("x-api-key","reqres-free-v1")
		.when()
		.get(ReqUtility.baseURL+"?page=5")
		.then()
		.log().all();

	}
	
	
}
