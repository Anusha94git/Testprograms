
package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class JavaScriptExecutor {

	public static void main(String[] args) 
	{
		WebDriver driver = null;
		String url = "https://www.facebook.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		
		driver.findElement(By.id("email")).sendKeys("hello");
		driver.findElement(By.id("pass")).sendKeys("hello");
		//<input value="Log In" aria-label="Log In" data-testid="royal_login_button" type="submit" id="u_0_8">
		
		WebElement login = driver.findElement(By.xpath("//input[@value='Log In' and @data-testid='royal_login_button']"));
		System.out.println("login identified");
		flash(login, driver);
		System.out.println("flash executed");
		drawcolor(login, driver);
		System.out.println("drawcolor executed");
		generatealert(driver, "There is an issue with this page");
		
		System.out.println("generatealert executed");
		Alert lt = driver.switchTo().alert();
		lt.accept();
		
		clickon(login, driver);
		System.out.println("clickon executed");
		
		refresh(driver);
		System.out.println("refresh executed");
		
		System.out.println(getTitle(driver));
		System.out.println("getTitle executed");
		
		System.out.println(getPageInnerText(driver));
		System.out.println("getPageInnerText executed");
		
		scrollpageDown(driver);
		System.out.println("scrolldown executed");
		driver.navigate().back();
		WebElement lang =driver.findElement(By.linkText("Sign Up"));
		scrollpageIntoView(lang, driver);
		System.out.println("scrollintiview executed");
	
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0;i<10;i++)
		{
			changecolor("rgb(0,200,0)", element, driver);
			changecolor(bgcolor, element, driver);
		}
	}
	
	public static void changecolor(String color,WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);
		try
		{
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			
		}
	}
	
	public static void drawcolor(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].style.border = '3px solid red'",element);
	}

	
	public static void generatealert(WebDriver driver,String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickon(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
		
	}
	
	public static void refresh(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static String getTitle(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.documentElement.innerText;").toString();
		return title;
	}
	
	public static void scrollpageDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	public static void scrollpageIntoView(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
}
