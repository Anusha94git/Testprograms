package com.NormalPrograms;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailWindowHandle {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://www.gmail.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		String parent = driver.getWindowHandle();
		System.out.println("parentid is : " +parent);
		System.out.println("title of parent page is : " +driver.getTitle());
		
		
		// <a href="https://support.google.com/accounts?hl=en-GB" target="_blank">Help</a>
				
		driver.findElement(By.linkText("Help")).click();
		
		
		Set<String> child = driver.getWindowHandles();
		System.out.println("childid is :" +child);
		System.out.println("title of child page is : " +driver.getTitle());
		
					
		for(String childwindow : child)
		{
			if(!childwindow.equals(parent))
			{
				driver.switchTo().window(childwindow);
				System.out.println("child id is " +childwindow);
				System.out.println("title of child page is : " +driver.getTitle());
				
				driver.findElement(By.linkText("Google Account")).click();
				
				System.out.println("title of page is : " +driver.getTitle());
				
				
																	
				driver.findElement(By.linkText("Help")).click();
				System.out.println("title of current page is : " +driver.getTitle());
						
				
				
			}
		}
		
	}

}
