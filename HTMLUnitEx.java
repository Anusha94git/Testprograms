package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HTMLUnitEx {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		WebDriver driver = null;
		String url = "http://newtours.demoaut.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
	//	driver = new ChromeDriver();
		
		driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		System.out.println("Title of homepage is : " +driver.getTitle());
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("tutorial");
		
		WebElement login = driver.findElement(By.name("login"));
		
		clickon(driver, login, 20);
		System.out.println("Title of login page is : " +driver.getTitle());
		
		driver.quit();
	}

	public static void clickon(WebDriver driver,WebElement locator, int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
