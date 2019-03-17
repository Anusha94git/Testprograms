package com.NormalPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboard {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url =  "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\Practicing_Programs\\driverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		FileInputStream file = new FileInputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\Logindetails.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row r = sheet.getRow(1);
		// int cellcount = r.getLastCellNum();
		
		driver.findElement(By.id("txtUsername")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());

		driver.findElement(By.id("btnLogin")).click();
		
		
		try
		{
			String Welcome =driver.findElement(By.id("welcome")).getText();
			
			Assert.assertEquals(Welcome, "Welcome Admin");
			
			r.createCell(2).setCellValue("login success");
			System.out.println("sucess");
			
		}
		catch(Exception e)
		{
			String fail1 = driver.findElement(By.id("spanMessage")).getText();
					//.equals("Invalid credentials");
			//String fail2= driver.findElement(By.id("spanMessage")).getText();
					//.equals("Csrf token validation failed"));
			System.out.println(fail1);
			//System.out.println(fail2);
			
			Assert.assertTrue("failed", fail1.contains("Invalid credentials"));
			//Assert.assertTrue("failed", fail2.contains("Csrf token validation failed"));
				File Failed = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Failed, new File("F:\\Javaworkspace\\Practicing_Programs\\Screenshot\\loginfailed.png"));
			System.out.println("failed");
			
			r.createCell(2).setCellValue("failed to login");
		}
		
		
		FileOutputStream file1 = new FileOutputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\LogindetailsReult1.xlsx");
		workbook.write(file1);
		
		
		Actions act = new Actions(driver);
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
		WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
		act.moveToElement(pim).build().perform();
		
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		
		FileInputStream fis = new FileInputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\AddEmployee.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = book.getSheet("Sheet1");
		int rowCount = sheet1.getLastRowNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			Row r1 = sheet1.getRow(i);
			
			int CellCount = r1.getLastCellNum();
			for(int j=0;j<=CellCount;j++)
			{
				driver.findElement(By.id("firstName")).sendKeys(r1.getCell(0).getStringCellValue());
				driver.findElement(By.id("middleName")).sendKeys(r1.getCell(1).getStringCellValue());
				driver.findElement(By.id("lastName")).sendKeys(r1.getCell(2).getStringCellValue());
				
				String Empid = driver.findElement(By.id("employeeId")).getAttribute("value");
				r1.createCell(3).setCellValue(Empid);
				
				FileOutputStream fos = new FileOutputStream("F:\\Javaworkspace\\Practicing_Programs\\ExcelSheets\\AddEmployeeResult.xlsx");
				book.write(fos);
				
				driver.findElement(By.id("photofile")).click();
				java.lang.Runtime.getRuntime().exec("F:\\Javaworkspace\\Practicing_Programs\\AutoITScripts\\AddEmployee_Photo.exe");
				
				// <input type="button" class="" id="btnSave" value="Save">
				
				driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
				
				
				// <input type="button" id="btnSave" value="Edit" class="">
				
				driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
				
				//<input value="" type="text" name="personal[txtLicenNo]" maxlength="30" class="editable" id="personal_txtLicenNo">
				//driver.findElement(By.id("personal_txtLicenNo")).sendKeys(r1.getCell(4).getStringCellValue());
				
				// <input type="button" id="btnSave" value="Save" class="">
				driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
				
				driver.navigate().back();
				
				

			}
			
			driver.navigate().back();
			driver.navigate().back();
		}
				
		
		
		
		
	}

	
	
	
	
}
