package com.NormalPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class XpathExample
{
	public static void main(String[] args) {
		
		WebDriver driver = null;
		String url = "https://www.ebay.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Title = driver.getTitle();
		System.out.println(Title);

		// <a href="https://www.ebay.com/b/Collectibles-Art/bn_7000259855" _sp="p2481888.m1383.l3250">Collectibles</a>
		//driver.findElement(By.linkText("Collectibles")).click();
		
		// //*[@id="mainContent"]/div[1]/ul/li[7]
		
		
		WebElement collect = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[7]"));
		Actions act = new Actions(driver);
		act.moveToElement(collect).build().perform();
		
		
		
}
}
