package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_Datepicker_Js {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
	//	String url = "http://jqueryui.com/datepicker/";
		
		String url = "https://www.spicejet.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		
		 // <input name="ctl00$mainContent$view_date1" type="text" readonly="readonly" id="ctl00_mainContent_view_date1" class="custom_date_pic required picker-first home-date-pick">
		 
		
		WebElement datepick = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		
		String dateval = "16/04";
		
		selectdatebyjs(driver, datepick, dateval);
		
		

		/*
		 * // demo-frame
		 
	WebElement frameEle=driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(frameEle);
	
	WebElement datepick = driver.findElement(By.id("datepicker"));
	String dateval = "04-01-1994";
	
	selectdatebyjs(driver, datepick, dateval);
	*/
	
	
		
		
	}
	
	public static void selectdatebyjs(WebDriver driver,WebElement element,String dateval)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", element);
	}

}
