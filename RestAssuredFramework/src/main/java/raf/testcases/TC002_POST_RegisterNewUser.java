package raf.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import raf.testbase.TestBase;
import raf.testutil.GeneratePostRequestDataUtil;

public class TC002_POST_RegisterNewUser extends TestBase {
	
	String fname = GeneratePostRequestDataUtil.getFirstName();
	String lname = GeneratePostRequestDataUtil.getLastName();
	String uname = GeneratePostRequestDataUtil.getUserName();
	String pwd = GeneratePostRequestDataUtil.getPassword();
	String email = GeneratePostRequestDataUtil.getEmail();
	Response httpResponse1;
	RequestSpecification httpRequest1;
	JSONObject jsobj;
	
	@BeforeClass
	public void registerNewUser()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/";
		
		httpRequest1 = RestAssured.given();
		
		//Creating Header
		httpRequest1.header("Content-Type","application/json");
		
		jsobj = new JSONObject();
		
		jsobj.put("FirstName", fname);
		jsobj.put("LastName", lname);
		jsobj.put("UserName", uname);
		jsobj.put("Password", pwd);
		jsobj.put("Email", email);
		System.out.println(fname + lname + uname + pwd + email);
		
		//now attach Json object to payload (request body) as below
		httpRequest1.body(jsobj.toJSONString());
		
		//After creating header and attaching json object as payload, send request and receive response
		httpResponse1 = httpRequest1.request(Method.POST,"customer/register");
		
	}
	
	@Test
	public void testStatusCodePOST()
	{
		int stacode = httpResponse1.getStatusCode();
		Assert.assertEquals(200, stacode);
	}
	
	@Test
	public void testResponseBodyPOST()
	{
		String resBody = httpResponse1.body().asString();
		System.out.println(resBody);
		
	}

}
