package com.NormalPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRMLogin {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String uname = "roott";
		String pwd = "Livetech7.30";
		
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
		
		// <input name="txtUsername" id="txtUsername" type="text">
		driver.findElement(By.id("txtUsername")).sendKeys("roott");
		//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		driver.findElement(By.id("txtPassword")).sendKeys("Livetech7.30");
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		// <a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a>
		
		driver.findElement(By.id("welcome")).click();
		// <li><a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a></li>
		driver.findElement(By.linkText("Logout")).click();
		

/********Validating through sendkeys ********/
		
		System.out.println("Validating through sendkeys");
		
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		
		
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
		/************Validating through excel sheet*************/
		System.out.println("Validating through excel sheet");
		FileInputStream fis = new FileInputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\Logindetails.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int RowCount = sheet.getLastRowNum();
		for(int i=1;i<=RowCount;i++)
		{
			Row r = sheet.getRow(i);
			
			//int CellCount = r.getLastCellNum();
			//for(int j=0;j<=CellCount;j++)
			//{
				
				driver.findElement(By.id("txtUsername")).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
				driver.findElement(By.id("btnLogin")).click();
				
										
				try
				{	
					 String expected_result ="Welcome Admin";
						
						String actual_result = driver.findElement(By.id("welcome")).getText();
					
						System.out.println("Expected result is : "+expected_result);
					System.out.println("Actual result is : " +actual_result);
					//Assert.assertEquals(expected_result, actual_result);
					
					if(actual_result.equals(expected_result))
					{
						System.out.println("if success");
						System.out.println("logged successfully - PASS");
						r.createCell(2).setCellValue("logged successfully - PASS");		
												
					}
				}
					catch(Exception e)
					{
						if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials")||driver.findElement(By.id("spanMessage")).getText().equals("Csrf token validation failed"))
						{
							File Orange_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
							
							
							FileUtils.copyFile(Orange_Screenshot, new File("F:\\Javaworkspace\\Practicing_Programs\\Screenshot\\loginfailed("+i+").png"));
							
							Thread.sleep(5000);
							System.out.println("***********************");
							System.out.println("failed to login - FAIL");
							r.createCell(2).setCellValue("failed to login - FAIL");
							
						
						}
					
					}
					
					
			//}
			
			FileOutputStream file1 = new FileOutputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\LogindetailsResult.xlsx");
			book.write(file1);
			
			driver.navigate().back();

			
		}
		
		
		

		

	}

}
