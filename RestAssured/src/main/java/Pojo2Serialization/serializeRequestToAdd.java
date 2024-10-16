package Pojo2Serialization;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
public class serializeRequestToAdd {
	
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	addPlace place=new addPlace();
	place.setAccuracy(234);
	place.setAddress("hinjewadi phase 1 , H20 bar dhandhli gali");
	place.setLanguage("marathi hindi english");
	Location location1=new Location();
	location1.setLat(345);
	location1.setLng(675);
	place.setLocation(location1);
	place.setName("Shivam Shukla");
	place.setPhone_number("87356746746");
	List<String> ls=new ArrayList<String>();
	ls.add("MAkle");
	ls.add("famle");
	place.setTypes(ls);
	place.setWebsite("www.shivamshetty.com");
	
	RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	.addQueryParam("Key", "qaclick123").setContentType(ContentType.JSON).build();//if we use this we not need to write RestAssured.BaseURI="url" and queryPara("key","value")
	
	ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(200)
	.expectContentType(ContentType.JSON).build();//if we use this we not need to write assertThat().statusCode(200)
	//
	
	
	RequestSpecification res=given().spec(reqSpec).body(place);//spec will get common info here 
	
	Response response=res.when().post("/maps/api/place/add/json").
	then().log().all().spec(resSpec).extract().response();
	
	String Result_res=response.asString();
	System.out.println(Result_res);
}

}
