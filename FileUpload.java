package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload 
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
		
			
		Assert.assertEquals(Title,"OrangeHRM");
		
		/********Validating through  data driectly in sendkeys********/
		
		System.out.println("Validating through data driectly in sendkeys");
		
		driver.findElement(By.id("txtUsername")).sendKeys("roott");
		driver.findElement(By.id("txtPassword")).sendKeys("Livetech7.30");
		driver.findElement(By.id("btnLogin")).click();
		
		Actions act = new Actions(driver);
		WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
		act.moveToElement(pim).build().perform();
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("hello");
		driver.findElement(By.id("middleName")).sendKeys("hello1");
		driver.findElement(By.id("lastName")).sendKeys("hello3");
		
		String Empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println(Empid);
		
		// <input class="duplexBox" type="file" name="photofile" id="photofile">
		driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\ANUSHA\\Downloads\\flower.png");
		
		
		/*driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();*/
		
}
}
