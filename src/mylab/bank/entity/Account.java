package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {

	// 계좌번호, 계좌소유자 이름, 현재 잔액
	private String accountNumber;
	private String ownerName;
	private double balance;

	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 기본적인 계좌 정보 관리
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	// 입금 기능
	public void deposit(double amount) {
		balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
	}

	// 출금 기능
	public void withdraw(double amount) throws InsufficientBalanceException {
		// 잔액이 부족할 때 발생하는 예외
		if (amount > balance) {
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
		}
		balance -= amount;
		System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
	}

	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
	}
}
