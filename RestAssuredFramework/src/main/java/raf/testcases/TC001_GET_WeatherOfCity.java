package raf.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import junit.framework.Assert;
import raf.testbase.TestBase;

public class TC001_GET_WeatherOfCity extends TestBase {
	
	@BeforeClass
	public void getWeatherOfCity() throws InterruptedException
	{
		httpLogger.info("Started...TC001_GET_WeatherOfCity....");
		RestAssured.baseURI="http://restapi.demoqa.com/";
		httpRequest =  RestAssured.given();
		httpResponse = httpRequest.request(Method.GET,"utilities/weather/city/"+cityName);
		Thread.sleep(3);
		

	}
	
	@Test
	public void testStatusCodeValidation()
	{
		int statusCode = httpResponse.getStatusCode();
		Assert.assertEquals(200, statusCode);
		
	}
	
	@Test
	public void testResponseBodyValidation()
	{
		String responseBody = httpResponse.getBody().asString();
		
		Assert.assertTrue(responseBody!= null);
		
		Assert.assertEquals(responseBody.contains(cityName), true);
		
	}
	
	@Test
	public void testStatusLineValidation()
	{
		String statusLine = httpResponse.getStatusLine();
		//Assert.assertEquals(statusLine.contains("http"), true);
		
	}
	
	@Test(enabled=false)
	public void testHeaderTypes()
	{
		Headers allReceivedHeaders = httpResponse.getHeaders();
		
		for(Header head: allReceivedHeaders)
		{
			
		}
		
		
	}
	
	
	@Test
	public void testResponseTimeValidation()
	{
		long responseTime = httpResponse.getTime();
		
		Assert.assertTrue(responseTime < 2000 );
		
		
	}
	
	@Test
	public void testContentTypeValidation()
	{
		String contentType = httpResponse.getHeader("Content-Type");
		
		Assert.assertEquals("application/json",contentType);
	}
	
	public void testContentEncodingValidation()
	{
		String contentEncoding = httpResponse.getHeader("Content-Encoding");
		
		Assert.assertEquals("gzip", contentEncoding);
	}
	
	public void testContentLength()
	{
		String lengthOfContent = httpResponse.getHeader("Content-Length");
		
		int intLengthOfContent = Integer.parseInt(lengthOfContent);
		
		Assert.assertTrue(intLengthOfContent < 200);
	}
		
	
	
	public void testServerTypeValidation()
	{
		String serverType = httpResponse.getHeader("Server");
		Assert.assertEquals("nginx", serverType);
	}
	
	public void testCookiesValidation()
	{
		String cookies = httpResponse.cookie("");
		System.out.println(cookies);
	}
	
	@AfterClass
	public void tearDown()
	{
		httpLogger.info("..Test Case 001 Finished...");
		
	}

}
