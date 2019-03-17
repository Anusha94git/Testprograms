package com.NormalPrograms;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar_dropdown {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "https://classic.crmpro.com/index.html";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");				
		driver = new ChromeDriver();
		
		//driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
		//Login
		driver.findElement(By.name("username")).sendKeys("AnushaI");
		driver.findElement(By.name("password")).sendKeys("test@123");
		////*[@id="loginForm"]/div/div/input
		
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input"));
		
		element1.click();
		
		//clickon(driver, element1, 120);
		
		
		String date = "14-September-2018";
		
		String dateArr[] = date.split("-");
		
		String daySelect = dateArr[0];
		String monthSelect = dateArr[1];
		String yearSelect = dateArr[2];
		
						
		WebElement frame = driver.findElement(By.name("mainpanel"));
		
		driver.switchTo().frame(frame);
		
		WebElement month = driver.findElement(By.name("slctMonth"));
		Select select = new Select(month);
		select.selectByVisibleText(monthSelect);
		
		
		WebElement year = driver.findElement(By.name("slctYear"));
		 select = new Select(year);
		 select.selectByVisibleText(yearSelect);
		 
		 
		 // /html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		 
		 // /html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		 
		 // /html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		 
		 // /html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/div[1]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[7]
		 
		 
		 
		 
		 // //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		 // //*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[7]
		 
		 String part1 = "//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
		 String part2 = "]/td[";
		 String part3 = "]";
		 
		 int totalweekdays = 7;
		 boolean flag = false;
		 
		 for(int rowNum=2;rowNum<=7;rowNum++)
		 {
			 for(int colNum=1;colNum<=totalweekdays;colNum++)
			 {
				 String dayvalue = driver.findElement(By.xpath(part1+rowNum+part2+colNum+part3)).getText();
				 System.out.println(dayvalue);
				 if(dayvalue.equals(daySelect))
				 {
					 driver.findElement(By.xpath(part1+rowNum+part2+colNum+part3)).click();
					 flag = true;
					 break;
					 
				 }
			 }
			 
			 if(flag)
			 {
				 break;
			 }
		 }
		 
		
		
		

	}
	
	/*public static void clickon(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
*/
}
