package com.itwill.member.test;

import javax.swing.JOptionPane;

import com.itwill.member.Member;
import com.itwill.member.MemberService;

public class MemberServiceTestMain {

	public static void main(String[] args) throws Exception{
		MemberService memberService=new MemberService();
		System.out.println("1.회원가입");
		boolean addSuccess1 = 
				memberService.addMember(new Member("xxxx", "xxxx", "엑스맨","경기도민", 30,"F", null));
		if(addSuccess1) {
			System.out.println("로그인화면으로이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된아이디입니다.");
		}
		boolean addSuccess2=
				memberService.addMember(new Member("bbbb", "bbbb", "비비맨","강원도민", 33,"T", null));
		if(addSuccess2) {
			System.out.println("로그인화면으로이동");
		}else {
			JOptionPane.showMessageDialog(null, "중복된아이디입니다.");
		}
		System.out.println("2.login");
		System.out.println(">>"+memberService.login("bbbb", "bbbb"));
		System.out.println(">>"+memberService.login("bbbb", "dfds"));
		System.out.println(">>"+memberService.login("pppp", "2323"));
		System.out.println();
		System.out.println("3.diplicateId");
		System.out.println(">>"+memberService.isDuplicateId("aaaa"));
		System.out.println(">>"+memberService.isDuplicateId("bbbb"));
		
		
		
		
		
		
		
		
		
	}

}
