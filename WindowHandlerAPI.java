package com.NormalPrograms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetTitle;

public class WindowHandlerAPI {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://www.popuptest.com/goodpopups.html";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(url);
		
		// <a class="black" href="http://www.popuptest.com/popup3.html" onclick="NewWindow(this.href,'rank','450','450','yes','center');return false" onfocus="this.blur()">Good PopUp #3</a>
		
		String parentwindowid = driver.getWindowHandle();
		System.out.println("parent id is :"+parentwindowid);
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> childwindowid = driver.getWindowHandles();
		
		System.out.println("child id is :" +childwindowid);
		
		/* for(String handle : childwindowid)
		{
			if(handle!=parentwindowid)
			{
				System.out.println("************");
				driver.switchTo().window(handle);
				System.out.println("title of child window is : "+driver.getTitle());
				driver.close();
				}
				
		}*/
		
		Iterator<String> handle = childwindowid.iterator();
		String child = handle.next();
		System.out.println(child);
		driver.switchTo().window(child);
		driver.close();
		
		
		

	}

}
