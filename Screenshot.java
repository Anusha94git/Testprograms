package com.NormalPrograms;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot
{
	public static void main(String[] args) throws IOException
	{
		
	WebDriver driver = null;
	String url = "https://www.google.com/?gws_rd=ssl";
	
	System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String Title = driver.getTitle();
	System.out.println(Title);
	
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("F:\\Javaworkspace\\Practicing_Programs\\Screenshot\\home.png"));
}
}
