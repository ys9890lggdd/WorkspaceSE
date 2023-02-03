package com.itwill03.포함;

public class BookLibraryMain {
	public static void main(String[] args) {
		/*
		 * 회원객체생성
		 */
		BookMember bookMember=
				new BookMember(1,"KIM","123-4567");
		/*
		 * 책객체생성
		 */
		Book rentBook=new Book(123, "자바", "IT","객체지향..");
		/*
		 * 회원이 책들 대여
		 * 
		 * 책객체참조변수를 회원의 멤버변수에대입
		 */
		bookMember.setBook(rentBook);
		/*
		 * 회원정보출력(회원정보와 회원이 빌린책들 정보출력)
		 */
		bookMember.print();
		
	}
}
