package com.tnsif.mini_project;

import java.util.Scanner;
import java.sql.*;
public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);
		int option;
		boolean exit = false;
		System.out.println("EMPLOYEE MANAGEMENT");
		while(!exit)
		{
			System.out.println("CHOOSE THE OPERATION TO PERFORM");
			System.out.println("1.INSERT \n2.DELETE \n3.SHOW \n4.UPDATE \n5.EXIT");
			option = in.nextInt();
			switch(option)
			{
			case 1 :
				System.out.println("Number of rows affected : "+Operations.insert());
				break;
			case 2 :
				System.out.println("Numer of rows affected : "+Operations.delete());
				break;
			case 3 :
				Operations.show();
				break;
			case 4 :
				System.out.println("Number of rows affected : "+Operations.update());
				break;
			case 5 :
				exit = true;
				System.out.println("Operations are done");
				break;
			default :
				System.out.println("CHOOSE A VALID OPTION !");
			}
			
		}
		in.close();

	}

}
