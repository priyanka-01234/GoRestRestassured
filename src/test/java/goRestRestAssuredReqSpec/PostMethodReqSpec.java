package goRestRestAssuredReqSpec;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import restAssuredSpecification.PostMethodRequestSpecific;

public class PostMethodReqSpec {
	PostMethodRequestSpecific reqSpec = new PostMethodRequestSpecific();
	
	
	@Test
	public void validPostMethod() {
		given()
		.body("{\r\n"
				+ "    \"id\": 8208133,\r\n"
				+ "    \"name\": \"Kanaka Ahluwalia\",\r\n"
				+ "    \"email\": \"kanujn ka_ahluwalia@kohler.example\",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"status\": \"inactive\"\r\n"
				+ "  }")
		.headers("Authorization"," Bearer 873b48a3475c39b6964834321617b282d8b69317eb1a09e04b22cb152417c694")
		.contentType(ContentType.JSON)
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(201);
		
	}

	//Same example by restAssured
	@Test
	public void validPostMethodByRestAssured() {
		
        given(reqSpec.validPostMethodRequest())
        .when()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test
	public void validPatchMethod() {
		given(reqSpec.validPatchmethod())	
		.when()
		.patch()
		.then()
		.log().all()
		.statusCode(200)
		.body("name", Matchers.equalTo("KanakaAhluwalia"));
		

	}
}
