package firstApi;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class getPlace {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("Key", "qaclick123").
		queryParam("place_id", "c4251f8a2b375439cc9727ccbf958d80").
		when()
		.get("/maps/api/place/get/json").
		then().log().all().assertThat().statusCode(200);

	}

}
