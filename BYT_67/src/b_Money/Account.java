package b_Money;

import java.util.Hashtable;

public class Account {
	private Money content;
	private Hashtable<String, TimedPayment> timedpayments = new Hashtable<String, TimedPayment>();
private String account_name; //added in purpose of testing
	
	Account(String name, Currency currency) {
		account_name=name;
		this.content = new Money(0, currency);
	}
//get name of an account for test
	public String getAccount_Name() {
		return account_name;
	}
	

	/**
	 * Add a timed payment
	 * @param id Id of timed payment
	 * @param interval Number of ticks between payments
	 * @param next Number of ticks till first payment
	 * @param amount Amount of Money to transfer each payment
	 * @param tobank Bank where receiving account resides
	 * @param toaccount Id of receiving account
	 */
//no error when TimedPayment already exists 
	
	public void addTimedPayment(String id, Integer interval, Integer next, Money amount, Bank tobank, String toaccount) {
		if(!timedPaymentExists(id)) {//changed part 
			TimedPayment tp = new TimedPayment(interval, next, amount, this, tobank, toaccount);
			timedpayments.put(id, tp);
		//added part
		}else {
		System.err.println("Timed payement which you re trying to add already exists"+ id + "id of payment");
			   }
		}
	
	/**
	 * Remove a timed payment
	 * @param id Id of timed payment to remove
	 */
//no error handling for case that payment does not exists
	public void removeTimedPayment(String id) {
		if(timedPaymentExists(id)) {
			timedpayments.remove(id);
		}else {
			System.err.println("Timed payment does not exists"+ id);
	          }
	}
	
	/**
	 * Check if a timed payment exists
	 * @param id Id of timed payment to check for
	 */
	public boolean timedPaymentExists(String id) {
		return timedpayments.containsKey(id);
	}

	/**
	 * A time unit passes in the system
	 */
//tp.tick(); twice instead of once 
	public void tick() {
		for (TimedPayment tp : timedpayments.values()) {
			 tp.tick(); 
			//tp.tick(); tp.tick();
		}
	}
	
	/**
	 * Deposit money to the account
	 * @param money Money to deposit.
	 */
	public void deposit(Money money) {
		content = content.add(money);
	}
	
	/**
	 * Withdraw money from the account
	 * @param money Money to withdraw.
	 */
//you can not withdraw more money than you have on the account
	public void withdraw(Money money) {
		/*if(this.getBalance() >  money) {
		System.err.println("You dont have this amount of money to withdraw");*/
	//}else{
		content = content.sub(money);
		//}
	}

	/**
	 * Get balance of account
	 * @return Amount of Money currently on account
	 */
//should return amount of money which is mentioned 2 lines above :)
//Return type changed to Integer.Previos Money
//public Money getBalance() {
	public Money getBalance() {
		//return content;
		return content;
	}

	/* Everything below belongs to the private inner class, TimedPayment */
	private class TimedPayment {
		private int interval, next;
		private Account fromaccount;
		private Money amount;
		private Bank tobank;
		private String toaccount;
		
		TimedPayment(Integer interval, Integer next, Money amount, Account fromaccount, Bank tobank, String toaccount) {
			this.interval = interval;
			this.next = next;
			this.amount = amount;
			this.fromaccount = fromaccount;
			this.tobank = tobank;
			this.toaccount = toaccount;
		}

		/* Return value indicates whether or not a transfer was initiated */
		public Boolean tick() {
			if (next == 0) {
				next = interval;

				fromaccount.withdraw(amount);
				try {
					tobank.deposit(toaccount, amount);
				}
				catch (AccountDoesNotExistException e) {
					/* Revert transfer.
					 * In reality, this should probably cause a notification somewhere. */
					fromaccount.deposit(amount);
				}
				return true;
			}
			else {
				next--;
				return false;
			}
		}
	}

}
