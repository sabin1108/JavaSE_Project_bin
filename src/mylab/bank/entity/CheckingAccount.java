package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	// 출금 한도 설정
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	// 출금 한도 관리
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		// 출금 시 한도 초과 검사
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: "
					+ withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}

	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}
}
