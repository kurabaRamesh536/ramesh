package com.stockaccounting.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class functionseg {
 
	public static WebDriver driver;
	public static String  srcpath="D:\\screen"; 

	
	public static void main(String[] args) throws IOException {
	
	function1();
	
	driver=new FirefoxDriver();	
	driver.get("http://google.com");
	functionseg f=new functionseg();
	f.takingScreenshots("ramesh");
	
	
	}
	
	public static void function1()
	{
	System.out.println("This is function1 code");
	}
	public void takingScreenshots(String name) throws IOException{
	
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(srcfile,new File(srcpath+"\\"+name+".jpg"));
	}
	
	
	
 
}
