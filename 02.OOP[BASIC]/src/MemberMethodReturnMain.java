
public class MemberMethodReturnMain {

	public static void main(String[] args) {
		MemberMethodReturn mmr = 
				new MemberMethodReturn();
		int returnData1 = 
				mmr.method1();
		System.out.println(
		"main block-->returnData1:"+returnData1);
		boolean returnData2=
				mmr.method2();
		System.out.println(
		"main block-->returnData2:"+returnData2);
		int returnData3 = 
				mmr.add(2132, 32478378);
		System.out.println(
				"main block-->returnData3:"+returnData3);
		System.out.println(
				"main block-->returnData4:"+mmr.add(1, 8));
		String name="김경호";
		String returnMessage1 = mmr.hello(name);
		/*
		 * returnMessage1--> 김경호님 안녕하세요!!
		 */
		
		System.out.println(
"main block-->returnMessage1:"+returnMessage1);
		System.out.println(
"main block-->returnMessage2:"+mmr.hello("kangcarry"));
		
		System.out.println("****************setter메쏘드호출*****************");
		mmr.setMemberField1(777777);
		mmr.setMemberField2(888888);
		mmr.setMemberField3(999999);
		System.out.println("****************getter메쏘드호출*****************");
		System.out.println("------main block memberField값 사용(출력)----- ");
		/*
		 * int memberField1=mmr.memberField1;
		 * System.out.println("memberField1:"+memberField1);
		 */
		int returnMemberField1 = mmr.getMemberField1();
		System.out.println("returnMemberField1:"+returnMemberField1);
		System.out.println("returnMemberField2:"+mmr.getMemberField2());
		System.out.println("returnMemberField3:"+mmr.getMemberField3());
	}

}











