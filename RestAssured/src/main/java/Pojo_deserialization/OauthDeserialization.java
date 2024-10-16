package Pojo_deserialization;

import static io.restassured.RestAssured.given;



import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;
import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;
public class OauthDeserialization {
		public static void main(String[] args) throws InterruptedException {

						// TODO Auto-generated method stub
			//this class will get the response from the API using tokens then 
			//conversting the json response to java class which we created in getCourses.java

			String response =

                given() 
                .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .formParams("grant_type", "client_credentials")

                        .formParams("scope", "trust")
                        .when().log().all()

                        .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

				System.out.println(response);

				JsonPath jsonPath = new JsonPath(response);

    		    String accessToken = jsonPath.getString("access_token");
    			System.out.println(accessToken);
    			getCourses gc=    given().queryParams("access_token", accessToken).when()
    			.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
    			.as(getCourses.class);//this will store the json response into getcourses class 
    			//and we can get the values of any object in response using gettters
    			System.out.println(gc.getLinkedIn());
    			System.out.println("TITLE  " + gc.getCourses().getApi().get(0).getCourseTitle()+" PRICE "+gc.getCourses().getApi().get(0).getPrice());

			}
		}


