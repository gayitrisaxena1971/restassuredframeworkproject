package raf.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response httpResponse;
	public Logger httpLogger;
	public static final String cityName = "Delhi";
	Properties prop;
	FileInputStream fis;
	public static String configPropertiesFile =  "Users/amitsaxena/Documents/workspace/RestAssuredFramework/src/main/java/raf/testconfig/config.properties";
	
	@BeforeClass
	public void setupRaf()
	{
		httpLogger = Logger.getLogger("RestAssuredFramework");
		//PropertyConfigurator.configure("log4j.properties");
		httpLogger.setLevel(Level.DEBUG);
		try
		{
			prop = new Properties();
			fis = new FileInputStream(configPropertiesFile);
			prop.load(fis);
		}
		catch(FileNotFoundException ex1)
		{
			System.out.println("FileNot Exception caught");
		} catch (IOException ex2) {
			System.out.println("IO Exception caught");
			
		}
		finally {
			
		}
		
		
	}
	
	
	

}
