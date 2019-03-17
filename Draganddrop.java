package com.NormalPrograms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop
{
	public static void main(String[] args) {
		
	WebDriver driver = null;
	String url = "https://jqueryui.com/droppable/";
	
	System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String Title = driver.getTitle();
	System.out.println(Title);

	
	// <iframe src="/resources/demos/droppable/default.html" class="demo-frame"></iframe>

	WebElement frame1 = driver.findElement(By.className("demo-frame"));
	driver.switchTo().frame(frame1);
	
	//<div id="draggable" class="ui-widget-content ui-draggable ui-draggable-handle" style="position: relative;">
	//<p>Drag me to my target</p>
	
	WebElement draggable = driver.findElement(By.id("draggable"));
	// droppable
	
	WebElement droppable = driver.findElement(By.id("droppable"));
	
	
	Actions act = new Actions(driver);
	
	act.dragAndDrop(draggable, droppable).build().perform();
	
	
	
	
	

}
}
