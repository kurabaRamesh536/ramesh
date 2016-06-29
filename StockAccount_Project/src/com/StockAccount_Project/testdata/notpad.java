package com.StockAccount_Project.testdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.StockAccount_Project.Master.stockmaster;

public class notpad {

	public static void main(String[] args) 
	{
	
	stockMaster sm=new stockmaster();
	string x="";
	string path=;
	string Rpath="D:\\notpad\\results";
	FileReader fr=new FileReader(path);
	BufferedReader br=new BufferedReader(fr);
	br.readLine();
	FileWriter fw=new FileWriter(Rpath);
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write("Uid&Desc&Result");
	bw.newLine();
	sm.stockAcc_Launch(sm.url);
	sm.stockAcc_Login(sm.uname, sm.pwd);
	while ((x=br.readLine())!=null)
	{
		System.out.println(x);
		String[] split=x.split("&");
		String U=split[0];
		String D=split[1];
		System.out.println(U+"--"+D);
		String res=sm.stockAcc_UnitofMcreation(U, D);
		bw.write(x+"&"+res);
		bw.newLine();
	}
	bw.close();
	br.close();
	sm.stockAcc_Logout();
	sm.stockAcc_Close();
}
	bw.close();
	br.close();
	sm.stockAcc_Logout();
	sm.stockAcc_Close();
	
	
		
		
	}

}
