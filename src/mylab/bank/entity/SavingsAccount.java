package mylab.bank.entity;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	// 이자율 관리
	public double getInterestRate() {
		return interestRate;
	}

	// 이자 적용 기능
	public void applyInterest() {
		double interest = getBalance() * interestRate;
		deposit(interest);
		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
	}

	@Override
	public String toString() {
		return super.toString() + ", 이자율: " + (interestRate * 100) + "%";
	}
}
