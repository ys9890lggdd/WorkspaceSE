package com.itwill00.variable;


public class DuoMemberInfoPrint{
	public static void main(String[] args) {
		/*
		 * 1.변수선언
		 */
		int no;//회원번호
		String name;//회원이름
		char gender;//회원성별('M','F')
		int age;//회원나이
		double height;//회원키
		
		/*
		 * 2.변수에 데이타(리터럴)대입
		 */
		no=1;
		name="김경호";
		gender='M';
		age=34;
		height=174.7;
		/*
		 * 3.변수 데이타 출력
		 */
		System.out.println("*********************************");
		System.out.println("회원번호:"+no);
		System.out.println("회원이름:"+name);
		System.out.println("회원성별:"+gender);
		System.out.println("회원나이:"+age);
		System.out.println("회원  키:"+height);
		System.out.println("*********************************");
		
		
	}
}