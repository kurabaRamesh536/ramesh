package com.StockAccount_Project.Master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class umodatadrivenxl {

	
	public static void main(String[] args)
	{
		stockmaster sm=new stockmaster();
		String xlpath="D:\\umo flie";
		String xlres="D:\\umo flie";
		FileInputStream fi=new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("UOMDATA");
		XSSFRow R=ws.getRow(3);
		XSSFCell C=R.getCell(0);
		
		System.out.println(C.getStringCellValue());
		
		int RC=ws.getLastRowNum();
		sm.stockAcc_Lanch(sm.url);
		sm.stockAcc_login(sm.uname, sm.pwd);
		for (int i = 1; i <= RC; i++) 
		{
			XSSFRow R1=ws.getRow(i);
			XSSFCell C1=R1.getCell(0);
			XSSFCell C11=R1.getCell(1);
			
			XSSFCell C2=R1.createCell(2);
			
			String Uid=C11.getStringCellValue();
			String Udesc=C11.getStringCellValue();
			
			System.out.println(Uid+"-----"+Udesc);
			String res=sm.stockAcc_UnitofMcreation(Uid, Udesc);
			C2.setCellValue(res);
			
		}
		
		FileOutputStream fo=new FileOutputStream(xlres);
		wb.write(fo);
		wb.close();
		sm.stockAcc_Logout();
		sm.stockAcc_Close();
			
		
	}

}
