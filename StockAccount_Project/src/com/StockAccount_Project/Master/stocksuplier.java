package com.StockAccount_Project.Master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class stocksuplier {
	public static WebDriver driver;
	public static String expval, actval;
	public String stockAcc_Supplier(String supname,String sadd,String scity,String cntry,String sname,String spno,String semail,String smno,String snotes)
	{	
		expval="Add succeeded";
		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath(".//a[@href='a_supplierslist.php']"));
		
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(supname);
		driver.findElement(By.id("x_Address")).sendKeys(sadd);
		driver.findElement(By.id("x_City")).sendKeys(scity);
		driver.findElement(By.id("x_Country")).sendKeys(cntry);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(sname);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(spno);
		driver.findElement(By.id("x__Email")).sendKeys(semail);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(smno);
		driver.findElement(By.id("x_Notes")).sendKeys(snotes);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		Sleeper.sleepTightInSeconds(5);
		actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
		System.out.println(actval);
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		
		if (expval.equalsIgnoreCase(actval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
		
}
}