/*
		논리연산자
		   - 형태:   ||(Logical OR) , && (Logical AND) ( |,& )
		   - 좌우측의항이 논리형변수(데이타)이다.
           - 결과도 논리형데이타이다.
		    ex> true || false, false && false

*/
public class OperatorLogical {

	public static void main(String[] args) {
		boolean b1, b2, b3, b4;
		boolean result;
		b1 = true;
		b2 = true;
		b3 = false;
		b4 = false;
		/*
		 * 논리합(logical or) || 
		 * --> false || false 인경우에만 false를 반환
		 */
		result = b1 || b2;
		System.out.println("true || true -->" + result);
		result = b1 || b3;
		System.out.println("true || false -->" + result);
		result = b3 || b1;
		System.out.println("false || true -->" + result);
		result = b3 || b4;
		System.out.println("false || false -->" + result);
		/*
		 * 논리곱(logical and) && 
		 * --> true || true 인경우에만 true를 반환
		 */
		result = b1 && b2;
		System.out.println("true && true -->"+result);
		result = b1 && b3;
		System.out.println("true && false -->"+result);
		result = b3 && b1;
		System.out.println("false && true -->"+result);
		result = b3 && b4;
		System.out.println("false && false -->"+result);
		
		int kor=56;
		int eng=67;
		
		/*
		 *  kor 점수의 유효성체크[0 ~ 100사이의정수]
		 */
		boolean condition1 = kor >= 0;
		boolean condition2 = kor<=100;
		
		boolean isValidScore = condition1 && condition2;
		System.out.println("국어점수 유효점수여부:"+isValidScore);
		
		boolean condition3 = kor>=90;
		boolean condition4 = eng>=90;
		
		System.out.println("--- A대학  국어점수가 90점이상이거나 영어점수가 90점이상이면합격");
		boolean isPass1 = condition3 || condition4;
		System.out.println("A대학합격여부:"+isPass1);
		System.out.println("--- B대학  국어,영어점수가 모두 90점이상이면합격");
		boolean isPass2=condition3 && condition4;
		System.out.println("B대학합격여부:"+isPass2);
		
		int math=78;
		boolean isValidMathScore   = (math>=0) && (math <= 100);
		System.out.println("수학점수의 유효성여부:"+isValidMathScore);
		boolean isInvalidMathScore = (math < 0)  || (math > 100) ;
		System.out.println("수학점수의 유효하지않은지여부:"+isInvalidMathScore);
		System.out.println("------배수판별-------");
		
		int number=12;
		
		boolean isMultiple3 = (number%3) == 0;
		System.out.println("3의배수여부:"+isMultiple3);
		boolean isMultiple4 = (number%4) == 0;
		System.out.println("4의배수여부:"+isMultiple3);
		boolean isMultiple34 = isMultiple3 && isMultiple4;
		System.out.println("3의배수이면서 4의배수여부(공배수):"+isMultiple34);
		/*
		 * Quiz: 윤년여부판단
		 *    - 4의배수(4로나누어떨어지는수)이면서 100의배수가아닌수(100로나누어떨어지는않는수) 이거나
		 *    - 400의배수(400로나누어떨어지는수)
		 */
		int year=2022;
		boolean isLeapYear = true;
		System.out.println(year+" 의 윤년여부:"+isLeapYear);
		System.out.println("-------문자연산-------");
		char c='S';
		
		boolean isHangul = (c >= '가') && (c<='힣');
		System.out.println("한글여부: "+isHangul);
		
		
		
	}

}
