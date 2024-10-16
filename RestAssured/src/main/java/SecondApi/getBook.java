package SecondApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class getBook {
	@Test
	public void getBookDetails() {
		RestAssured.baseURI="http://216.10.245.166";
		String res=given().queryParam("AuthorName","Shivam")
		.when().get("Library/GetBook.php")
		.then().extract().response().asString();
		System.out.println(res);
		JsonPath js=new JsonPath(res);
		String name=js.getString("book_name");
		System.out.println(name);
//		String[] arr=name.split(", ");
//		Assert.assertEquals(arr[1],"DSA using html");
	}
}
