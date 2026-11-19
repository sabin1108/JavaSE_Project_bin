package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {

	private List<Account> accounts;
	private int nextAccountNumber;

	// ArrayList 객체 생성 및 시작 계좌번호를 1000으로 설정
	public Bank() {
		accounts = new ArrayList<Account>();
		nextAccountNumber = 1000;
	}
	// 저축 계좌 생성
	public String createSavingsAccount(String ownerName, double balance, double interestRate) {
		String accountNumber = "AC" + nextAccountNumber;
		SavingsAccount account = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
		accounts.add(account);
		nextAccountNumber++;
		System.out.println("저축 계좌가 생성되었습니다: " + account);
		return accountNumber;
	}
	// 체킹 계좌 생성
	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
		String accountNumber = "AC" + nextAccountNumber;
		CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
		accounts.add(account);
		nextAccountNumber++;
		System.out.println("체킹 계좌가 생성되었습니다: " + account);
		return accountNumber;
	}
	// 계좌 조회
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
	}

	// 입금
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		findAccount(accountNumber).deposit(amount);
	}

	// 출금
	public void withdraw(String accountNumber, double amount)
			throws AccountNotFoundException, InsufficientBalanceException {
		findAccount(accountNumber).withdraw(amount);
	}

	// 계좌 이체
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
			throws AccountNotFoundException, InsufficientBalanceException {
		Account fromAccount = findAccount(fromAccountNumber);
		Account toAccount = findAccount(toAccountNumber);
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
	}

	// 모든 계좌 정보 출력
	public void printAllAccounts() {
		System.out.println("\n=== 모든 계좌 목록 ===");
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println("===================");
	}
}
