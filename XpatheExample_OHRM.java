package com.NormalPrograms;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpatheExample_OHRM
{

	public static void main(String[] args) throws IOException
	{
	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String Title = driver.getTitle();
	System.out.println(Title);
	
	// //*[@id="txtUsername"]
	driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys("roott");
	
	// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
	
	driver.findElement(By.xpath("//input[@name='txtPassword' and @id ='txtPassword']")).sendKeys("Livetech7.30");
	
	// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	
	driver.findElement(By.xpath("//input[contains(@id,'btnLogin']")).click();
	
	

}
}
