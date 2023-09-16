package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle route_urls = ResourceBundle.getBundle("routeurls");
		return route_urls;
	}
	
	
	public static Response createUser(User payload)
	{
		Response rs = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(getURL().getString("user_post_url"));
		
		return rs;
	}
	
	public static Response getUser(String username)
	{
		Response rs = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
			
			.when()
				.get(getURL().getString("user_get_url"));
			
			return rs;			
	}
	public static Response updateUser(String username, User payload)
	{
		Response rs = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", username)
			
			.when()
				.put(getURL().getString("user_update_url"));
			
			return rs;			
	}
	
	public static Response deleteUser(String username)
	{
		Response rs = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
			
			.when()
				.delete(getURL().getString("user_delete_url"));
			
			return rs;	
	}
}
