package com.NormalPrograms;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateOptions
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
	WebDriver driver = null;
	String url = "https://www.google.com/";
	
	System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String Title = driver.getTitle();
	System.out.println(Title);
	driver.navigate().to("http://amazon.com");
	Title = driver.getTitle();
	System.out.println(Title);
	Thread.sleep(2000);
	driver.navigate().refresh();
	
	driver.navigate().back();
	driver.navigate().forward();
	
}
}
