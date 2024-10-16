package RentalApi;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class updatingOrders {
	public static void updateOrder(String token ) {

		String ID=createOrder.getOrderiD();
		updatePojo up=new updatePojo();
		up.setCustomerName("Shivam Shetty");
		//>>>>>>>>>>>>>>>>>
		RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://simple-tool-rental-api.glitch.me")
				.addHeader("Authorization",token).setContentType(ContentType.JSON).build();
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(204)
				.build();

		RequestSpecification res=given().spec(reqSpec).body(up);
		Response response=res.when().patch("orders/"+ID+"").
				then().log().all().spec(resSpec).extract().response();


		//>>>>>>>>>>>>>below is without spec

		//		RestAssured.baseURI="https://simple-tool-rental-api.glitch.me";
		//		System.out.println(ID+"this is calling orderaId in updatee");
		//
		//
		//		given().header("Authorization",token)
		//				.header("Content-type","application/json").body(up)
		//				.when().patch("orders/"+ID+"")
		//		.then().assertThat().statusCode(204).extract().response();

	}

}
