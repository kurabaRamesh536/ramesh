package com.StockAccount_Project.testdata;

import java.io.FileInputStream;

public class excelprog {

	
	public static void main(String[] args) {
		stockMaster sm=new stockMaster();
		String xlpath="D:\\excel\\Book1.xlsx";
		String xlres="D:\\excel\\Book12.xlsx";
		FileInputStream fi=new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("UOMDATA");
//		XSSFRow R=ws.getRow(3);
//		XSSFCell C=R.getCell(0);
//		
//		System.out.println(C.getStringCellValue());
		
		int RC=ws.getLastRowNum();
		sm.stockAcc_Launch(sm.url);
		sm.stockAcc_Login(sm.uname, sm.pwd);
		for (int i = 1; i <= RC; i++) 
		{
			XSSFRow R=ws.getRow(i);
			XSSFCell C=R.getCell(0);
			XSSFCell C1=R.getCell(1);
			
			XSSFCell C2=R.createCell(2);
			
			String Uid=C.getStringCellValue();
			String Udesc=C1.getStringCellValue();
			
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

}
