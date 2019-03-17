package com.NormalPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DataDriven.Xls_Reader;

public class WebTable_Data_Excel 
{
	WebDriver driver = null;
	String url = "https://www.timeanddate.com/worldclock/";

	
	@BeforeMethod
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	public void excelsheet()
	{
		Xls_Reader reader = new Xls_Reader("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\NewtoursRegistrations.xlsx");
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody
		
		List<WebElement> table = driver.findElements(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		System.out.println("no of rows : "+table.size());
	int	rowCount = table.size();
		
	// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[7]
	List<WebElement> cols = driver.findElements(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td"));
	System.out.println("no of cols : "+cols.size());
	int	colsCount = cols.size();
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[7]
	
	String p1 = "/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
	String p2 = "]/td[";
	String p3 = "]";
	
	reader.addSheet("webtabledata2");
//	reader.addColumn("webtabledata2", "data");
	
		
		/*for(int i=1;i<rowCount;i++)
		{
			
			for(int j=1;j<colsCount;j++)
			{
				String row1 = driver.findElement(By.xpath(p1+i+p2+j+p3)).getText();
				System.out.print(row1 + " ");
								
				reader.setCellData("webtabledata2", "data", i, row1);
				
								
			}
			System.out.println();
			
		
			
		}
		*/
	
	String p8 = "/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
	String p9 = "]";
	reader.addColumn("webtabledata2", "data");
	
	for(int i=1;i<=rowCount;i++)
	{
		String row1 = driver.findElement(By.xpath(p8+i+p9)).getText();
		System.out.println(row1 + " ");
		//reader.addColumn("webtabledata2", "data");
		
		reader.setCellData("webtabledata2", "data", i, row1);
		
	}
			
		
	}

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}


}
