package com.NormalPrograms;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait 
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
	
	clickon(driver,driver.findElement(By.id("btnLogin")),20);
	
	

}
	
	public static void clickon(WebDriver driver,WebElement Locator,int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(Locator));
		Locator.click();
	}
	
}
