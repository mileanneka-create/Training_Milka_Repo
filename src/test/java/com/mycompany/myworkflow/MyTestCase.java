package com.mycompany.myworkflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCase 

{
	WebDriver driver;
	
	@BeforeTest
	public void setup() 
	
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new"); //run chrome in headless mode
		options.addArguments("--no-sandbox");  //run in a docker environment
		options.addArguments("--disable-dev-shm-usage"); //disable/dev/shm usage -  overcome limited resource problems
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void verifyPageTitle() 
	{
		String expectedTitle = "Google";
		driver.get("https://www.google.com");
		String actualTitle = driver.getTitle();
		
		System.out.println("This test case was developed by Milka Once Again!");
		System.out.println("Actual Title: " + actualTitle);
		System.out.println("Expected Title: " + expectedTitle);
		
		if (actualTitle.equals(expectedTitle)) 
		{
			System.out.println("Test Passed!");
		}
		else 
		{
			System.out.println("Test Failed!");
		}
	}
	@AfterTest
	public void tearDown() 
	{
		if(driver != null) 
		{
			driver.quit();
		}
	}
}	
