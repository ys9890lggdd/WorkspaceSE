
public class IfScorePrintReturn {

	public static void main(String[] args) {
		
		int kor=90;
		/*
		 * 점수 유효성체크
		 */
		if(kor<0 || kor>100) {
			System.out.println(kor+" 은 유효한점수가 아닙니다.");
			return;
		}
		/*
		 * 평점계산
		 */
		char hakjum='X';
		
		System.out.println("학점은 "+hakjum+ "입니다.");
		return;
	}

}
