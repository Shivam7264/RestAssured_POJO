package RentalApi;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class createOrder {
	private static  String orderiD;

	public static String getOrderiD() {
		return orderiD;
	}
	public  void setOrderiD(String orderiD) {
		this.orderiD = orderiD;
	}



	public  void createingOrder(String token) throws IOException {
		pojoCreate pc=new pojoCreate();
		pc.setToolId("1709");
		pc.setCustomerName("Shivam Shukl");
		pc.setComment("this is first comment");
		//>>>>>>>>>>>>>>>>>

		RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://simple-tool-rental-api.glitch.me")
				.addHeader("Authorization",token).setContentType(ContentType.JSON).build();
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification res=given().spec(reqSpec).body(pc);
		Response response=res.when().post("orders").
				then().log().all().spec(resSpec).extract().response();
		String res2=response.asString();
		JsonPath js= new JsonPath(res2);
		setOrderiD(js.getString("orderId"));
		System.out.println(getOrderiD()+"    this is getting orrrder id from create order");

		//>>>>>>>>>below code is without spec builder

		//		RestAssured.baseURI="https://simple-tool-rental-api.glitch.me";
		//		String res=given().header("Authorization",token)
		//		.header("Content-type","application/json")
		//		.body(pc)//serialization 
		//		.when().post("orders")
		//		.then().assertThat().statusCode(201).extract().response().asString();
		//		JsonPath js= new JsonPath(res);
		//		setOrderiD(js.getString("orderId"));
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	}


}
