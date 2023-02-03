package com.itwill03.포함.배열포함;

public class BookLibraryMain {
	public static void main(String[] args) {
		/*
		 * 회원객체생성
		 */
		BookMember bookMember1=
				new BookMember(1,"KANG", "010-552-8544");
		/*
		 * 책객체들생성
		 */
		Book[] books= {	
						new Book(111, "책1", "시", "좋은책"),
						new Book(222, "책2", "소설", "멋진책"),
						new Book(333, "책3", "IT", "어려운책")
						};
		/*
		 * 회원이 책들 대여
		 * 
		 * 책객체들 참조변수를 회원의 멤버변수에대입
		 */
		bookMember1.setBooks(books);
		/*
		 * 회원정보출력(회원정보와 회원이빌린들책정보출력)
		 */
		bookMember1.print();
	}
}
















