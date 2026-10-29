package com.mycompany.myworkflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupForm 
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
	public void signup() 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\milea\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/signup/");
		driver.findElement(By.name("uname")).sendKeys("Java");
		driver.findElement(By.id("email")).sendKeys("mileanneka@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"tel\"]")).sendKeys("913800900");
		
		WebElement gender = driver.findElement(By.name("sgender"));
	    Select selectGender = new Select(gender);
		selectGender.selectByVisibleText("Female");
		int n = selectGender.getOptions().size();
		System.out.println("Total number of options in Gender dropdown: " + n);
		
	}
	@AfterTest
	public void tearDown() 
	{
		if (driver != null) 
		{
			driver.quit();
		}
	}

}
