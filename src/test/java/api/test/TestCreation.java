package api.test;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCreation {
	
	Faker fk;
	User us;
	private static Logger log = LogManager.getLogger(TestCreation.class) ;

	@BeforeClass
	public void setData()
	{
		fk = new Faker();
		us = new User();
		
		us.setUsername(fk.name().username());
		us.setFirstname(fk.name().firstName());
		us.setLastname(fk.name().lastName());
		us.setEmail(fk.internet().emailAddress());
		us.setPassword(fk.internet().password());
		us.setPhone(fk.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void createUser()
	{
		log.info("*** Testcase execution got started ****");
		Response rs = UserEndPoints.createUser(us);
		log.info("*** Testcase execution got processed ****");
		Assert.assertEquals(rs.getStatusCode(), 200);
		log.info("*** Testcase execution got completed ****");
		
	}
	
	@Test(priority=2)
	public void getUser()
	{
		log.info("*** Testcase execution got started ****");
		Response rs = UserEndPoints.getUser(this.us.getUsername());
		 ResponseBody data = rs.getBody();
		log.info("*** Testcase execution got processed ****");
		Assert.assertEquals(rs.getStatusCode(), 200);
		System.out.println(data.jsonPath().get("email"));
		log.info("*** Testcase execution got completed ****");
	}
	
	@Test(priority=3)
	public void updateUser()
	{
		us.setFirstname(fk.name().firstName());
		us.setLastname(fk.name().lastName());
		us.setEmail(fk.internet().emailAddress());
		us.setPassword(fk.internet().password());
		us.setPhone(fk.phoneNumber().cellPhone());
		
		log.info("*** Testcase execution got started ****");
		Response rs = UserEndPoints.updateUser(this.us.getUsername(), us);
		log.info("*** Testcase execution got processed ****");
		Assert.assertEquals(rs.getStatusCode(), 200);
		log.info("*** Testcase execution got completed ****");
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		log.info("*** Testcase execution got started ****");
		Response rs = UserEndPoints.deleteUser(this.us.getUsername());
		log.info("*** Testcase execution got processed ****");
		Assert.assertEquals(rs.getStatusCode(), 200);
		log.info("*** Testcase execution got completed ****");
	}

}
