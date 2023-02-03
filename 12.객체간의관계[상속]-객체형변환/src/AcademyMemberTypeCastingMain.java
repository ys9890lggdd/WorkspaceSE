
public class AcademyMemberTypeCastingMain {

	public static void main(String[] args) {
		/*
		 public class AcademyStudent extends AcademyMember {}
		 public class AcademyGangsa extends AcademyMember {}
		 public class AcademyStaff extends AcademyMember {}
		 
		 AcademyMember의 자식타입객체(AcademyStudent,AcademyGangsa,AcademyStaff)들은
		 AcademyMember 타입변수에 대입가능
		 */
		AcademyStudent st1=new AcademyStudent(1,"KIM","ANDROID");
		AcademyMember m1=st1;
		AcademyMember m2=new AcademyStudent(2, "LEE", "JAVA");
		AcademyMember m3=new AcademyStudent(3, "JIM", "OFFICE");
		
		AcademyMember m4=new AcademyGangsa(4, "박강사","보안");
		AcademyMember m5=new AcademyGangsa(5, "정강사","빅데이타");
		
		AcademyMember m6=new AcademyStaff(6, "천상룡", "회계팀");
		AcademyMember m7=new AcademyStaff(7, "박승곤", "원장");
		/*****AcademyMember에정의되지않은 메쏘드호출불가능**
		String ban = m1.getBan();
		******************************************************/
		/****AcademyMember에정의된 메쏘드중 재정의된메쏘드호출가능****
		 - AcademyMember타입에 정의된 print 메쏘드를 호출하면
		 - AcademyMember의 자식타입객체(AcademyStudent,AcademyGangsa,AcademyStaff)의
		  	재정의된 print메쏘드가호출된다.
		*/
		m1.print();
		
		System.out.println("-------------AcademyMember들전체출력---------");
		m1.print();
		m2.print();
		m3.print();
		m4.print();
		m5.print();
		m6.print();
		m7.print();
		
	}

}














