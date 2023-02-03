
public class AcademyMemberArrayTypeCastingMain {

	public static void main(String[] args) {
		
		/*
		AcademyMember[] members=new AcademyMember[7];
		members[0] =new AcademyStudent(0, null, null);
		*/
		
		AcademyMember[] members= {
			new AcademyStudent(1, "KIM", "JAVA"),	
			new AcademyStudent(2, "LIM", "DESIGN"),	
			new AcademyStudent(3, "MIM", "ANDROID"),	
			new AcademyGangsa(4, "OIM", "ANDROID"),
			new AcademyGangsa(5, "PIM", "JAVA"),
			new AcademyStaff(6, "QIM", "ACCOUNTING"),
			new AcademyStaff(7, "RIM", "MARKETING")
		};
		/*#########################################################*/
		System.out.println("----AcademyMember전체출력----");
		for(int i=0;i<members.length;i++) {
			/*
			 * AcademyStudent,AcademyGangsa,AcademyStaff에서 재정의된 print메쏘드호출
			 */
			members[i].print();
		}
		
		System.out.println("-------instanceof-----");
		/*
		 * 연산자--> instanceof
		 *    - 형태    : 참조변수 instanceof 클래스이름
		 *    - 연산결과: true or false
		 *    - ex> boolean b = receiveMembers[0] instanceof AcademyStudent;
		 */
		AcademyMember am=new AcademyStudent(90,"김학생","정보처리");
		if(am instanceof AcademyStudent) {
			AcademyStudent tempStudent = (AcademyStudent)am;
			String tempBan=tempStudent.getBan();
			System.out.println("학생반:"+tempBan);
		}
		System.out.println("------AcademyMember배열에있는 객체들중에서 AcademyStudent객체들만출력------");
		for(int i=0;i<members.length;i++) {
			if(members[i] instanceof AcademyStudent) {
				members[i].print();
				AcademyStudent tempStudent=(AcademyStudent)members[i];
				System.out.println("학생반:"+tempStudent.getBan());
				
			}
		}
		
	}

}












