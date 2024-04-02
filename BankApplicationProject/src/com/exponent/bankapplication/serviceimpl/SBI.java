package com.exponent.bankapplication.serviceimpl;

import java.util.Scanner;

import com.exponent.bankapplication.model.Account;
import com.exponent.bankapplication.service.RBI;

public class SBI implements RBI {

	Scanner sc = new Scanner(System.in);
	Account ac = new Account();

	public static int Getvaliduserdetails() {
		Scanner sc = new Scanner(System.in);
		try {
			int userinput = sc.nextInt();
			return userinput;
		} catch (Exception e) {
			System.out.println("------Invalid Input Please try again!!!----");
			return Getvaliduserdetails();
		}

	}

	public static long Getvalidlonginput() {
		Scanner sc = new Scanner(System.in);
		try {
			long userinput1 = sc.nextLong();
			return userinput1;
		} catch (Exception e) {
			System.out.println("-------Invalid Input!!! Please Try again--------");
			return Getvalidlonginput();
		}
	}

	public static long Getvaliddoubleinput() {
		Scanner sc = new Scanner(System.in);
		try {
			long userinput2 = sc.nextLong();
			return userinput2;
		} catch (Exception e) {
			System.out.println("-------Invalid Input!!! Please Try again--------");
			return Getvaliddoubleinput();
		}
	}

	public long getvalidaccountNO() {
		long accountNumber = Getvalidlonginput();
		String straccountNumber = String.valueOf(accountNumber);
		if (straccountNumber.length()== 8) {

			ac.setAccountNo(accountNumber);
			return accountNumber;
		} else {
			System.out.println("Please enter eight digit acc number!!! ");
			return getvalidaccountNO();
		}
	}

	public int GetValidAadharcard() {
		int aadharCard = Getvaliduserdetails();
		String straadharcard = String.valueOf(aadharCard);
		if (straadharcard.length() == 12) {
			ac.setAadharCard(aadharCard);
			return aadharCard;
		} else {
			System.out.println("----Invalid AadharCard Number----");
			return GetValidAadharcard();
		}
	}

	@Override
	public void registerAccount() {
		System.out.println("enter your account number");
		getvalidaccountNO();

		System.out.println("enter your name ");
		String name = sc.next();
		char uname = name.charAt(0);

		if (uname >= 65 && uname <= 90) {
			ac.setAccountName(name);
		} else {
			System.out.println("Please enter first letter capital!!! And Try again");

		}

		System.out.println("enter aadharcard");
		GetValidAadharcard();
		

		System.out.println("enter pancard");
		String pancard = sc.next();
		ac.setPancard(pancard);

		System.out.println("enter your mobile no ");
		long contact = Getvalidlonginput();
		ac.setContactNo(contact);

		System.out.println("Enter bank account opening amount");
		double accountBalance = Getvaliddoubleinput();
		ac.setAccountBalance(accountBalance);

		System.out.println("@@@@ACCOUNT REGISTRATION SUCCESS@@@@@@");
	}

	@Override
	public void showAccountDetails() {

		System.out.println("Enter your account Number ");
		int enteredAccountNumber = Getvaliduserdetails();

		if (ac.getAccountNo() == enteredAccountNumber) {

			System.out.println(ac.getAccountName() + " " + ac.getAccountBalance() + " " + ac.getContactNo());

		} else {
			System.out.println("Account doesn't exist");
		}

	}

	@Override
	public void showAccountBalance() {
		System.out.println("Enter your account Number ");
		int enteredAccountNumber = Getvaliduserdetails();

		if (ac.getAccountNo() == enteredAccountNumber) {

			System.out.println("CURRENT ACCOUNT NUMBER :" + ac.getAccountBalance());

		} else {
			System.out.println("Account doesn't exist");
		}
	}

	@Override
	public void withdrawMoney() {

		System.out.println("Enter your account Number ");
		int enteredAccountNumber = Getvaliduserdetails();
		if (ac.getAccountNo() == enteredAccountNumber) {

			System.out.println("Please Enter amount you wish to withdraw");
			int enterAmount = Getvaliduserdetails();

			if (enterAmount > ac.getAccountBalance()) {
				System.out.println("Insuffcient Balance");

			} else if (enterAmount > ac.getAccountBalance() - 50) {
				System.out.println("Insuffcient Balance!! Atleast 50rs required in account");
			} else {
				if (enterAmount % 100 == 0) {
					double updatedBalance = ac.getAccountBalance() - enterAmount;
					ac.setAccountBalance(updatedBalance);
					System.out.println("Withdraw Successful");
					System.out.println("Your updated Balance is: " + ac.getAccountBalance());
				} else {
					System.out.println("Enter the amount in multiple of 100!!!");
				}
			}

		} else {
			System.out.println("Account doesn't exist");
		}
	}

	@Override
	public void depositMoney() {

		System.out.println("Enter your account Number ");
		int enteredAccountNumber = Getvaliduserdetails();
		if (ac.getAccountNo() == enteredAccountNumber) {

			System.out.println("Please Enter amount you wish to Deposit");
			int enterAmount = Getvaliduserdetails();
			double updatedBalance = ac.getAccountBalance() + enterAmount;
			ac.setAccountBalance(updatedBalance);

			System.out.println("Deposit Successful");
			System.out.println("Your updated Balance is: " + updatedBalance);

		} else {
			System.out.println("Account doesn't exist");
		}

	}

	@Override
	public void updateAccountDetails() {

		System.out.println("Enter your account Number ");
		int enteredAccountNumber = Getvaliduserdetails();
		if (ac.getAccountNo() == enteredAccountNumber) {

			boolean flag = true;

			while (flag) {
				System.out.println("1: UPDATE CONTACT");
				System.out.println("2: UPDATE NAME");

				System.out.println("Please select what you want to update:");
				int choice = Getvaliduserdetails();

				switch (choice) {

				case 1:
					updateMobileNumber();
					flag = false;
					break;

				case 2:
					updateAccountName();
					flag = false;
					break;

				default:
					System.out.println("Wrong Choice pls enter in between 1 to 2 choice");
					flag = false;
					break;
				}
			}
		} else {
			System.out.println("Account doesn't exist");
		}

	}

	public void updateMobileNumber() {

		System.out.println("Please enter new Mobile number: ");
		long updateContact = Getvalidlonginput();
		ac.setContactNo(updateContact);
		System.out.println("Your updated mobile number is: " + updateContact);
		System.out.println("");
		System.out.println("Mobile number updated Successfully");

	}

	public void updateAccountName() {
		System.out.println("Please enter your Name: ");
		String updateName = sc.next();
		ac.setAccountName(updateName);
		System.out.println("Your updated mobile number is: " + updateName);
		System.out.println("");
		System.out.println("Name updated Successfully");

	}
}
