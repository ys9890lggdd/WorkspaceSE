package com.itwill05.service.array.account;

public class AccountServiceReturnMain {
	public static void main(String[] args) {
		AccountServiceReturn accountServiceReturn = 
				new AccountServiceReturn();
		
		System.out.println("0.AccountServiceReturn객체야 은행계좌객체인자로줄께 추가해줘");
		
		accountServiceReturn.addAccount(1112, "JAN", 10000, 1.0);
		accountServiceReturn.addAccount(new Account(1113, "HON", 89890, 8.9));
		accountServiceReturn.addAccount(new Account(1114, "GON", 99890, 3.9));
		accountServiceReturn.addAccount(new Account(1115, "FON", 49890, 5.9));
		
		System.out.println("1.AccountServiceReturn객체야 은행계좌 총계좌수를 반환해줘");
		int totAccountNumber = accountServiceReturn.getTotAccountNumber();
		System.out.println(">>은행총계좌수:" + totAccountNumber);
		System.out.println("2.AccountServiceReturn객체야 은행계좌들 전체출력해줘");
		accountServiceReturn.print();
		System.out.println("3.AccountServiceReturn객체야 은행계좌들 총잔고를 반환해줘");
		int totBalance = accountServiceReturn.getAccountTotBalance();
		System.out.println(">>은행총계좌잔고:" + totBalance);
		System.out.println("4.AccountServiceReturn객체야 "
			+ "계좌번호를인자로 넣어줄께 계좌한개참조변수를 반환해줘");
		Account findAccount=accountServiceReturn.findByNo(1111);
		if(findAccount!=null) {
			findAccount.print();
		}
		findAccount = accountServiceReturn.findByNo(3424);
		if(findAccount!=null) {
			findAccount.print();
		}
		
		System.out.println("5.AccountServiceReturn객체야 계좌잔고를 인자로줄께 잔고이상인 계좌객체배열 참조변수반환해줘");
		Account[] finAccounts=
				accountServiceReturn.findByBalance(80000);
		for (Account account : finAccounts) {
			account.print();
		}
		System.out.println("6.AccountServiceReturn객체야 계좌이율(5.0)을 인자로줄께 이율이상인 계좌객체배열 참조변수 반환해줘");
		System.out.println("7.AccountServiceReturn객체야 계좌주이름(AIM)을 인자로줄께 계좌객체배열 참조변수 반환해줘");
		/*
		Account[] accounts = 
				accountServiceReturn.findByName("AIM");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		*/
		System.out.println("8.AccountServiceReturn객체야 계좌번호(6666번)와 입금할돈(4000원)줄께 입금한후 계좌객체참조변수반환해줘");
		Account ipGumAccount = 
				accountServiceReturn.ipGum(6666, 333);
		ipGumAccount.print();
		System.out.println("9.AccountServiceReturn객체야 계좌번호(1111번)와 출금할돈(500원)줄께 출금한후 계좌객체참조변수반환해줘");
		Account chulGumAccount=
				accountServiceReturn.chulGum(1111, 1);
		chulGumAccount.print();
		/*
		정렬기준(standard) --> 1:번호,2:이름,3:잔고,4:이율 
		정렬방법(order)    --> 1:오름차순,2:내림차순
		 */
		System.out.println("10.AccountServiceReturn객체야 계좌를 잔고순으로 오름차순정렬해줘");
		accountServiceReturn.sort(AccountServiceReturn.SORT_BY_BALANCE, AccountServiceReturn.SORT_ASC);
		accountServiceReturn.print();
		System.out.println("11.AccountServiceReturn객체야 계좌를 잔고순으로 내림차순정렬해줘");
		accountServiceReturn.sort(AccountServiceReturn.SORT_BY_BALANCE, AccountServiceReturn.SORT_DESC);
		accountServiceReturn.print();
		
		System.out.println("12.AccountServiceReturn야 계좌객체줄께 이름,잔고,이율 수정(update)해줘");
		Account updateAccount=new Account(3333, "CHANGE", 89899, 3.3);
		accountServiceReturn.updateAccount(updateAccount);
		System.out.println("13.AccountServiceReturn야 계좌데이타줄께 이름,잔고,이율 수정(update)해줘");
		accountServiceReturn.updateAccount(4444,"사사",9000,10);
		/*
		<< 과제아님 >>
		System.out.println("14.AccountServiceReturn객체야 계좌번호줄께 계좌삭제한후 삭제한계좌객체반환해줘[OPTION]");
		*/
		accountServiceReturn.print();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
