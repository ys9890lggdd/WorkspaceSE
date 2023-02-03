public class MemberFieldMain {
	public static void main(String[] args) {
		System.out.println("---main start---");
		/*
		 * MemberField 사용자정의타입 객체의 주소값을 저장할변수선언(참조변수)
		 */
		MemberField mf1;
		/*
		 * MemberFiled클래스(틀)로 객체생성한후에 객체의 참조변수 mf1 에 생성된객체의 주소값이 대입(#100)
		 */
		mf1 = new MemberField();
		
		
		/*
		 * mf1(#100)주소에있는 객체의 int 		타입의 멤버변수 member1에 77	값을 대입
		 * mf1(#100)주소에있는 객체의 double	타입의 멤버변수 member2에 3.14159	값을 대입
		 * mf1(#100)주소에있는 객체의 char		타입의 멤버변수 member3에 'A' 		값을 대입
		 * mf1(#100)주소에있는 객체의 String	타입의 멤버변수 member4에 "김수한무거북이~~" 값을 대입
		 *
		 * - 객체의 참조(주소)변수가가지고있는 객체의 주소값 #100를 사용해서 멤버필드에 데이타대입
		 * - 객체의 멤버필드접근방법
		 *    - 참조(주소)변수.멤버필드이름 = 값;
		 *    - mf1.member1=77;
		 */
		mf1.member1 = 77;
		mf1.member2 =3.14159;
		mf1.member3='A';
		mf1.member4="김수한무거북이~~";
		
		
		/*
		 * mf1객체의 int   타입 멤버변수 member1의값을 출력
		 * mf1객체의 double타입 멤버변수 member2의값을 출력
		 * mf1객체의 char  타입 멤버변수 member3의값을 출력
		 * mf1객체의 String타입 멤버변수 member4의값을 출력
		 * 
		 * - 객체의 참조(주소)변수가가지고있는 객체의 주소값 #100를 사용해서 멤버필드의 값출력
		 * - 객체의 멤버필드접근방법
		 *   
		 *   1. System.out.println(mf1.member1);
		 *   2.
		 *   	int tempMember1 =mf1.member1;
		 *   	System.out.println(tempMember1);
		 * 
		 */
		System.out.println("mf1의주소값:"+mf1);
		System.out.println(mf1.member1);
		System.out.println(mf1.member2);
		System.out.println(mf1.member3);
		System.out.println(mf1.member4);
		
		
		MemberField mf2= new MemberField();
		mf2.member1=88;
		mf2.member2=1.142145;
		mf2.member3='F';
		mf2.member4="제임스딘";
		System.out.println(mf2.member1);
		System.out.println(mf2.member2);
		System.out.println(mf2.member3);
		System.out.println(mf2.member4);
		System.out.println("---main end---");

	}

}
