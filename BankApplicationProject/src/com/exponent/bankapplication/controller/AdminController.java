package com.exponent.bankapplication.controller;
import com.exponent.bankapplication.serviceimpl.SBI;
import com.exponent.bankapplication.service.RBI;

import java.util.Scanner;

public class AdminController {
	
	public static int Getvaliduserdetails() {
		Scanner sc  = new Scanner(System.in);
		try {
			int userinput = sc.nextInt();
			return userinput;
		} catch (Exception e) {
			System.out.println("------Invalid Input Please try again!!!----");
			return Getvaliduserdetails();
		}
		
	}

	public static void main(String[] args) {

		System.out.println("***WELCOME TO SBI BANK****");
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		RBI rbi = new SBI();

		while (flag) {

			System.out.println("-------------------------------------------");
			System.out.println("-------------------------------------------");
			System.out.println("1: CREATE BANK ACCOUNT                     ");
			System.out.println("2: SHOW ACCOUNT DETAILS                    ");
			System.out.println("3: SHOW ACCOUNT BALANCE                    ");
			System.out.println("4: DEPOSIT MONEY                           ");
			System.out.println("5: WIHTDRAW MONEY                          ");
			System.out.println("6: UPDATE ACCOUNT DETAILS                  ");
			System.out.println("7: EXIT                                    ");
			System.out.println("-------------------------------------------");
			System.out.println("-------------------------------------------");

			System.out.println("**ENTER YOUR CHOICE*******");
			int ch =  Getvaliduserdetails();

			switch (ch) {
			case 1:
				rbi.registerAccount();
				break;
			case 2:
				rbi.showAccountDetails();
				break;
			case 3:
				rbi.showAccountBalance();
				break;
			case 4:
				rbi.depositMoney();
				break;
			case 5:
				rbi.withdrawMoney();
				break;
			case 6:
				rbi.updateAccountDetails();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Wrong Choice pls enter in between 1 to 7 choice ");
				break;

			}

		}
		sc.close();
		System.out.println("***THANK YOU FOR BANKING****");

	}
}
