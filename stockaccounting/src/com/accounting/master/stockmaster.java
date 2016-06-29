package com.accounting.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class stockmaster 
{
public static String url="http://webapp.qedgetech.com";
public static WebDriver driver;
public static String expval, actval;
public static FileInputStream fi;
public static Properties pr;
public static String prop="D:\\ramesh";

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
	driver.findElement(by.)

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
	
	}
	


