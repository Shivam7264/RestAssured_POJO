package RentalApi;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getOrders {

	public static void getOrder(String token) {
		RestAssured.baseURI="https://simple-tool-rental-api.glitch.me";
		String res=given().header("Authorization",token)
				.header("Content-type","application/json")
				.when().get("orders")
				.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);
	}


}
