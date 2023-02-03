package com.itwill.guest.test;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestServiceTestMain {

	public static void main(String[] args)  throws Exception{
		GuestService guestService=new GuestService();
		System.out.println("1.방명록쓰기");
		System.out.println(guestService.guestWrite(new Guest(0, "아무개", null, "uunknown@naver.com", "www.google.com", "몰라요", "내용도몰라요")));
		System.out.println("4.방명록1개보기");
		Guest guest=guestService.guestDetail(24);
		System.out.println(">>"+guest);
		System.out.println("2.방명록수정");
		guest.setGuest_name("수정이름");
		guest.setGuest_homepage("www.change.co.kr");
		System.out.println(">>"+ guestService.guestUpdate(guest));
		System.out.println("3.방명록삭제");
		System.out.println(">> "+guestService.guestDelete(10));
		System.out.println("5.방명록이름으로검색 보기");
		System.out.println(">> "+guestService.findByGuestName("김봉선"));
		System.out.println("6.방명록 리스트보기");
		System.out.println(">> "+guestService.guestList());
	}

}
