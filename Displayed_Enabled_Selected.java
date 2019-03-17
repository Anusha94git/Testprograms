package com.NormalPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Displayed_Enabled_Selected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://newtours.demoaut.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		int size = elements.size();
		System.out.println("Number of links available : " +size);
		
		for(int i=0;i<size;i++)
		{
			
			String data = elements.get(i).getText();
			if(elements.get(i).isDisplayed())
			{
				System.out.println(data);
			}
			
		}
		
		
		driver.findElement(By.linkText("REGISTER")).click();
		// <select name="country" size="1">
        //<option value="2">ALBANIA </option>
        
	WebElement country =driver.findElement(By.name("country"));
	
	List<WebElement> names = country.findElements(By.tagName("option"));
	
	size = names.size();
	System.out.println(size);
	
	for(int i=0;i<size;i++)
	{
		names.get(i).click();
		if(names.get(i).isSelected())
		{
			System.out.println(names.get(i).getText());
		}
	}
	
	String url2 = "https://www.facebook.com/";
	driver.navigate().to(url2);
	
	// <input type="radio" name="sex" value="1" id="u_0_9">
List<WebElement> sex =driver.findElements(By.xpath("//input[@type='radio' and @name='sex']"));
for(int i=0;i<sex.size();i++)
{
	sex.get(i).click();
	if(sex.get(i).isEnabled())
	{
		System.out.println(sex.get(i));
	}
}

	
	
		
	}
	
	
	
	
	

}
