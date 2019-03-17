package com.NormalPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	public static void main(String[] args) 	
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "https://www.timeanddate.com/worldclock/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[7]
		
		//Method-1
		
		/*
		String part1 = "/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String part2 = "]/td[";
		String part3 = "]";
		
		for(int i=1;i<=36;i++)
		{
			for(int j=1;j<=7;j++)
			{
				String data = driver.findElement(By.xpath(part1+i+ part2+j+part3)).getText();
				System.out.print(data + " ");
						
				
			}
			System.out.println();
		}
		
		*/
		
		
		//Method-2
		/*
		
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]"));
		
		List<WebElement> rows	=	table.findElements(By.tagName("tr"));
		
		System.out.println(rows.size());
		
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<cols.size();j++)
			{
				String data= cols.get(j).getText();
				System.out.print(data + " ");
			}
			System.out.println();
			System.out.println();
		}
	
	*/
		
		
		//Method-3
		
		WebElement element1  = driver.findElement(By.xpath("//span[@id='p76s']/parent::td//preceding-sibling::td//span[@id='p40s']"));
		clickon(element1, driver, 90);
		
		
	
	

}

	public static void clickon(WebElement element,WebDriver driver,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
