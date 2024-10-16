package RentalApi;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class register {

	private static String Token;


	public static void setToken(String token) {
		Token = token;
	}


	public String getToken() {

		return Token;
	}


	public void registering() throws IOException {
		pojo_register pj=new pojo_register();
		pj.setClientEmail(utilities.generateRandomEmail());
		pj.setClientName(utilities.generateRandomString(5));
		//>>>>>>>>

				RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://simple-tool-rental-api.glitch.me")
						.setContentType(ContentType.JSON).build();
				ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(201)
						.build();
				
				RequestSpecification res=given().spec(reqSpec).body(pj);
				Response response=res.when().post("api-clients").
						then().log().all().spec(resSpec).extract().response();
				String res2=response.asString();
				JsonPath js= new JsonPath(res2);
				setToken(js.getString("accessToken"));
				System.out.println(getToken());

		//>>>>>>>


//		RestAssured.baseURI="https://simple-tool-rental-api.glitch.me";
//		String res=given().log().all().header("Content-Type","application/json").body(pj)
//				.when().post("api-clients")
//				.then().extract().response().asString();
//		JsonPath js=new JsonPath(res);
//		setToken(js.getString("accessToken"));
//		System.out.println(getToken());


	}
}
