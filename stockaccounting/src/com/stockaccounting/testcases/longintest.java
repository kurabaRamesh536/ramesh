package com.stockaccounting.testcases;

import com.accounting.master.stockmaster;

public class longintest {

	
	public static void main(String[] args) 
	{
		stockmaster sm=new stockmaster();
		String res=sm.stockAcc_Lanch(sm.url);
		System.out.println(res);
		
		res=sm.stockAcc_login("admin", "master");
		System.out.println(res);
	}

}
