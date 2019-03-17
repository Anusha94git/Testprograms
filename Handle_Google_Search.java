package com.NormalPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Google_Search {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "https://www.google.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		// <input class="gLFyf gsfi" maxlength="2048" name="q" type="text" jsaction="paste:puy29d" aria-autocomplete="both" 
		//aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" role="combobox" spellcheck="false" title="Search" value="" aria-label="Search">
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi' and @name = 'q' and @title='Search']")).sendKeys("testing");
		
		// //*[@id="tsf"]/div[2]/div/div[2]/div[2]
		// <ul class="erkvQe" jsname="erkvQe" role="listbox">
		//<div class="aajZCb" jsname="aajZCb"><ul class="erkvQe" jsname="erkvQe" role="listbox">
		
	List<WebElement> listbox = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class='sbl1']"));
	
	for(int i=0;i<listbox.size();i++)
	{
		System.out.println(listbox.get(i).getText());
	}
	
	for(int i=0;i<listbox.size();i++)
	{
		
		if(listbox.get(i).getText().contains("testing tools"))
		{
			listbox.get(i).click();
			break;
			
		}
	}
	
	//System.out.println(listbox);

}
}
