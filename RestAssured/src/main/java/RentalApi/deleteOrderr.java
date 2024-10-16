package RentalApi;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class deleteOrderr {

	public static void deleteOrder(String token) {
		createOrder c=new  createOrder();
		String orderID=c.getOrderiD();
		deletePojo dp= new deletePojo();
		dp.setCustomerName("Shivam Shetty");

		//>>>>>>>
		RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://simple-tool-rental-api.glitch.me")
				.addHeader("Authorization",token).setContentType(ContentType.JSON).build();
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(204).build();


		RequestSpecification res=given().spec(reqSpec).body(dp);
		Response response=res.when().delete("orders/"+orderID+"").
				then().log().all().spec(resSpec).extract().response();


		//>>>>>>>>>>>>>>>>>>>> below without spec builder

		//		RestAssured.baseURI="https://simple-tool-rental-api.glitch.me";
		//
		//		given().header("Authorization",token)
		//				.header("Content-type","application/json").body(dp)
		//				.when().delete("orders/"+orderID+"")
		//		.then().assertThat().statusCode(204).extract().response();
	}

}
