package com.stockaccounting.Examples;

import java.util.Scanner;

public class palindrome
{

	
	public static void main(String[] args)
	{
		String p="";
		Scanner sc=new Scanner(System.in);
System.out.println("Enter the value");
String S=sc.next();
System.out.println(S);
int count=S.length();
System.out.println(count);
S.charAt(2);
for(int i=count-1; i>0; i--)
{
	char reverse=S.charAt(i);
	p=p+reverse;
	
}
System.out.println(p);
if(S.equals(p))
System.out.println(S+"number is palindrome ");
else
	System.out.println(S+"number is not palindrome ");
	}

}
