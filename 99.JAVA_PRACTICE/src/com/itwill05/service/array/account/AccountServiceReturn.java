package com.itwill05.service.array.account;

/*
 * 1.계좌객체들(Account[]) 을멤버변수로가진다.
 * 2.계좌객체들을 사용해서 업무실행
 */
public class AccountServiceReturn {

	public static final int SORT_BY_NO=1;
	public static final int SORT_BY_OWNER=2;
	public static final int SORT_BY_BALANCE=3;
	public static final int SORT_BY_IYUL=4;
	
	public static final int SORT_ASC=1;
	public static final int SORT_DESC=2;

	private Account[] accounts = { 
			new Account(1111, "KIM", 85000, 5.9), 
			new Account(2222, "JIM", 77000, 4.2),
			new Account(3333, "FIM", 56000, 1.2), 
			new Account(4444, "SIM", 77000, 0.2),
			new Account(5555, "GIM", 94000, 3.2), 
			new Account(6666, "AIM", 56000, 6.2),
			new Account(7777, "XIM", 33000, 7.2), 
			new Account(8888, "QIM", 77000, 5.2),
			new Account(9999, "AIM", 80000, 1.2) };
	/*
	 * 0.계좌객체를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(Account newAccount) {
		/*
		 * 1.배열크기증가 
		 * 	- 기존배열보다큰배열생성 
		 * 	- 기존데이타 옮김
		 */
		Account[] tempAccount=new Account[accounts.length+1];
		
		for(int i=0;i<accounts.length;i++) {
			tempAccount[i]=accounts[i];
		}
		tempAccount[tempAccount.length-1]=newAccount;
		accounts=tempAccount;
	}
	/*
	 * 0.계좌데이타를 인자로받아서 Account[]에추가[OPTION]
	 */
	public void addAccount(int no, String owner, int balance, double iyul) {
		Account newAccount=new Account(no, owner, balance, iyul);
		this.addAccount(newAccount);
	}
	/*
	 * 1.은행계좌들 총계좌수 반환메써드
	 */
	public int getTotAccountNumber() {
		return accounts.length;
	}

	/*
	 * 2.은행계좌들 전체출력메쏘드 정의
	 */
	public void print() {
		Account.headerPrint();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
	}

	/*
	 * 3.은행계좌들 총잔고를 반환하는 메쏘드
	 */
	public int getAccountTotBalance() {
		int totBalance=0;
		for (Account account : accounts) {
			totBalance+=account.getBalance();
		}
		return totBalance;
	}

	/*
	 * 4.계좌번호를 인자로받아서 계좌객체주소 한개반환
	 */
	public Account findByNo(int no){
		Account finAccount=null;
		
		for (Account account : accounts) {
			if(account.getNo()==no) {
				finAccount = account;
				break;
			}
		}
		
		return finAccount;
	}

	/*
	 * 5.계좌잔고 인자로받아서 잔고이상인 계좌배열객체 참조변수반환
	 */
	public Account[] findByBalance(int balance) {
		Account[] findAccounts=null;
		/*
		 * A. 만족하는 객체의갯수구하기 - 예를들어 3개라면
		 */
		int count=0;
		for (Account account : accounts) {
			if(account.getBalance()>=balance) {
				count++;
			}
		}
		/*
		 * B. Account객체배열생성 
		 * 	- findAccounts=new Account[3];
		 */
		findAccounts=new Account[count];
		/*
		 * C. 만족하는Account객체들 Account배열에담기
		 */
		int index=0;
		for (Account account : accounts) {
			if(account.getBalance()>=balance) {
				findAccounts[index] = account;
				index++;
			}
		}
		return findAccounts;
	}
	/*
	 * 6.계좌이율인자로받아서 인자이상인 계좌들배열객체 참조변수반환
	 */
	public Account[] findByIyul(double iyul) {
		return null;
	}

	/*
	 * 7.계좌주이름 인자로받아서 이름과일치하는계좌들배열객체 참조변수반환
	 */
	public Account[] findByName(String name) {
		/*
		 * A. 만족하는 객체의갯수구하기 - 예를들어 3개라면
		 */
		
		/*
		 * B. Account객체배열생성 
		 * 	- findAccounts=new Account[3];
		 */
		
		/*
		 * C. 만족하는Account객체들 Account배열에담기
		 */
		
		return null;
	}

	/*
	 * 8.계좌번호,입금할돈 인자로 받아서 입금한후 입금계좌 참조변수반환
	 */
	public Account ipGum(int no, int m) {
		/*
		 * 1.계좌번호로 계좌찾기 
		 * 2.입금
		 * 3.입금계좌 참조변수반환
		 */
		Account findAccount=this.findByNo(no);
		findAccount.deposit(m);
		return findAccount;

	}

	/*
	 * 9.계좌번호,출금할돈 인자로 받아서 출금
	 */
	public Account chulGum(int no, int m) {
		Account findAccount=this.findByNo(no);
		findAccount.withDraw(m);
		return findAccount;
	}

	/*
	 * 10,11 정렬  standard --> 1:번호,2:이름,3:잔고,4:이율 
	 *             order    --> 1:오름차순,2:내림차순
	 */
	public void sort(int standard, int order) {
		if(standard==AccountServiceReturn.SORT_BY_BALANCE) {
			if(order==AccountServiceReturn.SORT_ASC) {
				//오름차순
				for(int i=0;i<accounts.length-1;i++) {
					for(int j=0;j<accounts.length-1;j++) {
						if(accounts[j].getBalance() > accounts[j+1].getBalance()) {
							Account tempAccount = accounts[j];
							accounts[j]=accounts[j+1];
							accounts[j+1]=tempAccount;
						}
					}
				}
			}else if(order==AccountServiceReturn.SORT_DESC) {
				//내림차순
				for(int i=0;i<accounts.length-1;i++) {
					for(int j=0;j<accounts.length-1;j++) {
						if(accounts[j].getBalance() < accounts[j+1].getBalance()) {
							Account tempAccount = accounts[j];
							accounts[j]=accounts[j+1];
							accounts[j+1]=tempAccount;
						}
					}
				}
			}
		}
	}

	/*
	 * 12.계좌객체를 인자로 받아서 이름,잔고,이율 수정(update)[OPTION]
	 */
	public void updateAccount(Account updateAccount) {
		/****************case 1********************
		Account account = this.findByNo(updateAccount.getNo());
		account.setOwner(updateAccount.getOwner());
		account.setBalance(updateAccount.getBalance());
		account.setIyul(updateAccount.getIyul());
		*/
		/****************case 2********************/
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getNo()==updateAccount.getNo()) {
			   accounts[i]=updateAccount;
				break;
			}
		}
	}

	/*
	 * 13.번호,이름,잔고,이율 인자로받아서 계좌객체수정(update)[OPTION]
	 */
	public void updateAccount(int no, String owner, int balance, double iyul) {
		/****************case1***********
		Account findAccount=this.findByNo(no);
		findAccount.setAccountData(no, owner, balance, iyul);
		*/
		Account updateAccount=new Account(no, owner, balance, iyul);
		this.updateAccount(updateAccount);
	}
	/*
	 << 과제아님 >>
	 * 14.계좌번호 인자로받아서 삭제해줘[OPTION] 
	 * 	A. 배열에서 Account객체삭제 
	 * 	B. 배열사이즈감소
	 *  C. 삭제한계좌객체반환
	 *  
	 */
	public Account deleteByNo(int no) {
		return null;
	}
	
}










