package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Title = driver.getTitle();
		System.out.println(Title);
		
		// <input type="submit" name="proceed" value="Go" title="Sign in" tabindex="4">
		
		driver.findElement(By.name("proceed")).click();
		org.openqa.selenium.Alert alt= driver.switchTo().alert();
		
		System.out.println(alt.getText());
		alt.accept();
	}

}
