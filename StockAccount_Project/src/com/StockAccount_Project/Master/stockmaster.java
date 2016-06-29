package com.StockAccount_Project.Master;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class stockmaster 
{
public static String url="http://webapp.qedgetech.com";
public static WebDriver driver;
public static String expval, actval;
public static FileInputStream fi;
public static Properties pr;
public static String uname,pwd;
public static String prop="D:\\Qedge 7.30\\StockAccount_Project\\src\\com\\StockAccount_Project\\Properties\\stockaccount.properties";

public static String stockAcc_Lanch(String url) throws IOException
{
	fi=new FileInputStream(prop);
	pr=new Properties();
	pr.load(fi);
	expval="login";
	driver=new FirefoxDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();


	actval=driver.findElement(By.id(pr.getProperty("login"))).getText();

	if(expval.equalsIgnoreCase(actval))
	{
		return "Pass";
	}
	else
	{
		return "Fail";
	}
	
	}


	public String stockAcc_login(String user,String pwd)
	{
	expval="administrator"; 
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(user);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.id("btnsubmit")).click();
	actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
	if (expval.equalsIgnoreCase(actval))
	{
		return "Pass";
	}
	else
	{
		return "fail";
	}
	
	
	}
	
	public String stockAcc_Supplier(String supname,String sadd,String scity,String cntry,String sname,String spno,String semail,String smno,String snotes)
	{
		expval="Add succeeded";
		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
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
		actval=driver.findElement(By.xpath(".//div[@class='alert alert-success ewSuccess']")).getText();
		System.out.println(actval);
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath(".//button[@class='ajs-button btn btn-primary']")).click();
		
		if (expval.equalsIgnoreCase(actval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
		
}
	public String stockAcc_UnitofMcreation(String Uid,String Udesc)
	{
		WebElement sitem=driver.findElement(By.linkText("Stock Items"));
		
		Actions act=new Actions(driver);
		act.moveToElement(sitem).build().perform();
		
		driver.findElement(By.linkText("Unit of Measurement")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_UOM_ID")).sendKeys(Uid);
		driver.findElement(By.id("x_UOM_Description")).sendKeys(Udesc);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(10);
		List<WebElement> button=driver.findElements(By.tagName("button"));
		System.out.println(button.size());
		for (int i = 0; i < button.size(); i++) 
		{
			String text=button.get(i).getText();
			
			if (text.equalsIgnoreCase("OK!"))
			{
				button.get(i).click();
				break;
			}
			
		}
		String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	System.out.println(actval);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		Sleeper.sleepTightInSeconds(5);
		String count=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[2]/form/div[2]/span[2]")).getText();
		String[] split=count.split(" ");
		System.out.println(split.length);
		int count1=Integer.parseInt(split[2]);
		int pcount=0;
		System.out.println(split[0]+"--"+split[1]+"--"+split[2]);
		boolean flag = false;
		do 
		{
			List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='tbl_a_unit_of_measurementlist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) 
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				String acttext=cols.get(2).getText();
				System.out.println(acttext);
				if (acttext.equalsIgnoreCase(Uid)) 
				{
					System.out.println("category available");
					flag=true;
					break;
				}
			
			}
			if (flag==false) 
			{
				driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
			}
			pcount++;
			
		} 
		while (pcount<=count1);

		if (flag==true) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
}
	