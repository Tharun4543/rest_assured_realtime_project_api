package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.PetstorePostDataProvider;
import io.restassured.response.Response;

public class PetSwaggerDataDriven {
	
	User us;
	
	@Test(priority=1, dataProvider="PostBodyData",dataProviderClass=PetstorePostDataProvider.class)
	public void createUsersData(String id, String username, String firstName,  String lastName,  String email, String password,  String phone)
	{
		us = new User();
		us.setId(Integer.parseInt(id));
		us.setUsername(username);
		us.setFirstname(firstName);
		us.setLastname(lastName);
		us.setEmail(email);
		us.setPassword(password);
		us.setPhone(phone);
		
		Response rs = UserEndPoints.createUser(us);
		Assert.assertEquals(rs.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="userNamesData",dataProviderClass=PetstorePostDataProvider.class)
	public void deleteUsernamesData(String username)
	{
		Response rs = UserEndPoints.deleteUser(username);
		
		Assert.assertEquals(rs.getStatusCode(), 200);
	}
	

}
