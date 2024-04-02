package com.exponent.bankapplication.model;

public class Account {
	
	private long accountNo;
	private String accountName;
	private int aadharCard;
	private String pancard;
	private long contactNo;
	private double accountBalance;

	
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(int aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}
