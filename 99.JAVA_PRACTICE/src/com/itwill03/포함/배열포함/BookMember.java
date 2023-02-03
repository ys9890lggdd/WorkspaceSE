package com.itwill03.포함.배열포함;


public class BookMember {
	//회원번호
	private int no;
	//회원이름
	private String name;
	//전화번호
	private String phoneNumber;
	//빌린책들
	private Book[] books;
	public BookMember() {
	}
	
	public BookMember(int no, String name, String phoneNumber) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public BookMember(int no, String name, String phoneNumber, Book[] books) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.books = books;
	}

	public void setBooks(Book[] books) {
		this.books=books;
	}
	public Book[] getBooks() {
		return this.books;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void print() {
		System.out.println(this.no+"\t"+this.name+"\t"+this.phoneNumber);
		if(books!=null) {
			for (Book book : books) {
				book.print();
			}
		}else {
			
		}
	}
	
	
	
	
}









