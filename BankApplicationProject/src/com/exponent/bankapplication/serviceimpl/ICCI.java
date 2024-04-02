package com.exponent.bankapplication.serviceimpl;

import java.util.Scanner;

import com.exponent.bankapplication.model.Account;
import com.exponent.bankapplication.service.RBI;

public class ICCI implements RBI{
	
	Scanner sc = new Scanner(System.in);
	Account[] acc_arr = new Account[5];
	
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
	
	
	@Override
	public void registerAccount() {
		
		System.out.println("How many accounts you want create : ");
		int n = Getvaliduserdetails();

		for (int i = 0; i < n; i++) {// 012

			Account ac = new Account();

			System.out.println("Enter ac No : ");
			int acNo = Getvaliduserdetails();
			ac.setAccountNo(acNo);
			
			System.out.println("enter your name ");
			String name = sc.next();
			ac.setAccountName(name);
			
			System.out.println("enter aadharcard");
			int aadgarCard = sc.nextInt();
			ac.setAadharCard(aadgarCard);
			
			System.out.println("enter pancard");
			String pancard = sc.next();
			ac.setPancard(pancard);
			
			System.out.println("enter your mobile no ");
			long contact = sc.nextLong();
			ac.setContactNo(contact);

			System.out.println("Enter Balance : ");
			double bal = sc.nextDouble();
			ac.setAccountBalance(bal);

			acc_arr[i] = ac;

		}
	
		
	}
	@Override
	public void showAccountDetails() {
		
		for (Account ac : acc_arr) {
			if (ac != null)
				System.out.println(ac);
		}
		
		
	}
	
	
	@Override
	public void showAccountBalance() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void withdrawMoney() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void depositMoney() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void updateAccountDetails() {
		// TODO Auto-generated method stub
		
	}

}
