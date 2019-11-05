package raf.testutil;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratePostRequestDataUtil {
	/*
	public static void main(String [] args)
	{
		System.out.println(getFirstName());
		System.out.println(getLastName());
		System.out.println(getUserName());
		System.out.println(getPassword());
		System.out.println(getEmail());
		
	}
	*/
	
	public static String getFirstName()
	{
		String fnameRandomStr  = RandomStringUtils.randomAlphanumeric(2);
		return "Ajit" + fnameRandomStr;
		
	}
	
	public static String getLastName()
	{
		String lnameRandomStr = RandomStringUtils.randomAlphanumeric(2);
		return "Agarkar" + lnameRandomStr;
		
	}
	
	public static String getUserName()
	{
		String userNameRandomStr =RandomStringUtils.randomAlphanumeric(2);
		return "aj" + userNameRandomStr;
		
	}
	
	public static String getPassword()
	{
		String passwordRandomStr = RandomStringUtils.randomAlphanumeric(2);
		return "agarkar" + passwordRandomStr;
		
	}
	
	public static String getEmail()
	{
		String emailRandomStr = RandomStringUtils.randomAlphanumeric(2);
		return "agarkar"+ emailRandomStr+ "@xyz.org";
		
	}

}
