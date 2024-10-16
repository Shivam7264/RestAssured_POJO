package SecondApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class addBook {
	@Test
	public void adding() {
		RestAssured.baseURI="http://216.10.245.166";
		
		given().header("Content-Type","application/json").
		body(payload.addBook()).when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

}
