package com.itwill.member;
/*
insert into member(m_id,m_password,m_name,m_address,m_age,m_married,m_regdate) values('aaaa','aaaa','김경수','부산시 영도구',37,'F',sysdate);
update member set  m_password='0000', m_name='김변경', m_address='제주도민', m_age=20,m_married='T',m_regdate=sysdate where m_id='aaaa';
delete from member where m_id='aaaa';
select m_id,m_password,m_name,m_address,m_age,m_married,m_regdate from member where m_id='bbbb';
select m_id,m_password,m_name,m_address,m_age,m_married,m_regdate from member;
*/
public class MemberSQL {
	public static final String  MEMBER_INSERT=
	"insert into member(m_id,m_password,m_name,m_address,m_age,m_married,m_regdate) values(?,?,?,?,?,?,sysdate)";
	public static final String  MEMBER_UPDATE=
	"update member set m_password=?,m_name=?,m_address=?,m_age=?,m_married=? where m_id=?";
	public static final String  MEMBER_DELETE=
	"delete from member where m_id=?";
	public static final String  MEMBER_SELECT_BY_ID=
	"select m_id,m_password,m_name,m_address,m_age,m_married,m_regdate from member where m_id=?";
	public static final String  MEMBER_SELECT_ALL=
	"select m_id,m_password,m_name,m_address,m_age,m_married,m_regdate from member";
}
