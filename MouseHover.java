package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Title = driver.getTitle();
		System.out.println(Title);
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("roott");
		driver.findElement(By.id("txtPassword")).sendKeys("Livetech7.30");
		driver.findElement(By.id("btnLogin")).click();

		
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/admin/viewAdminModule" id="menu_admin_viewAdminModule" class="firstLevelMenu"><b>Admin</b></a>
		
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		
		Actions act = new Actions(driver);
		act.moveToElement(admin).build().perform();
		
		//<a href="#" id="menu_admin_Job" class="arrow">Job</a>
		WebElement Job = driver.findElement(By.linkText("Job"));
		act.moveToElement(Job).build().perform();
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/admin/viewJobTitleList" id="menu_admin_viewJobTitleList">Job Titles</a>
		
		WebElement jobTitle = driver.findElement(By.linkText("Job Titles"));
		act.moveToElement(jobTitle).click().build().perform();
		
	
	
	
	
	
	
	
	
	
	}
}