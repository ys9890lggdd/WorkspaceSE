
public class PrimitiveTypeArrayStudentMain {

	public static void main(String[] args) {
		System.out.println("---학생10명 성적데이타를 저장하기위한 배열객체생성 초기화----");
		int[] noArray= {1,2,3,4,5,6,7,8,9,10};
		String[] nameArray = { "KIM", "LEE", "PARK", "CHOI", "SIM", "KIM", "PIM", "MIN", "AIM", "LIM" };
		int[] korArray = { 12, 80, 34, 66, 98, 93, 82, 61, 72, 80 };
		int[] engArray = { 32, 46, 64, 96, 58, 98, 62, 81, 32, 99 };
		int[] mathArray = { 93, 89, 88, 46, 54, 23, 90, 85, 73, 34 };
		int[] totArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		double[] avgArray = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		char[] gradeArray = { 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F' };
		int[] rankArray = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		
		/*
		 * 총점,평균,평점계산
		 */
		for(int i=0;i<noArray.length;i++) {
			totArray[i]=korArray[i]+engArray[i]+mathArray[i];
			avgArray[i]=totArray[i]/3.0;
			
			if(avgArray[i]>=90) {
				gradeArray[i]='A';
			}else if(avgArray[i]>=80) {
				gradeArray[i]='B';
			}else if(avgArray[i]>=70) {
				gradeArray[i]='C';
			}else if(avgArray[i]>=60) {
				gradeArray[i]='D';
			}else {
				gradeArray[i]='F';
			}
			
		}
		/*
		 * 총점으로 석차계산
		 */
		
		/*
		 * 1번학생(index-->0)석차계산
		 */
		for(int j=0;j<totArray.length;j++) {
			if(totArray[0] < totArray[j]) {
				rankArray[0]++;
			}
		}
		/*
		 * 2번학생(index-->1)석차계산
		 */
		for(int j=0;j<totArray.length;j++) {
			if(totArray[1] < totArray[j]) {
				rankArray[1]++;
			}
		}
		/*
		 * 3번학생(index-->2)석차계산
		 * 4번학생(index-->3)석차계산
		 * 5번학생(index-->4)석차계산
		 * 6번학생(index-->5)석차계산
		 * 7번학생(index-->6)석차계산
		 * 8번학생(index-->7)석차계산
		 * 9번학생(index-->8)석차계산
		 * 10번학생(index-->9)석차계산
		 */
		
		/*
		 * 학생검색(번호,국어,영어,수학,학점,석차)
		 */
		
		/*
		 * 번호3번인학생 1명찾아서 1명정보출력(학생번호는 중복되지않는다.)
		 */
		System.out.println(">>번호3번인학생 1명찾아서 1명정보출력(학생번호는 중복되지않는다.)");
		for(int i=0;i<noArray.length;i++) {
			if(noArray[i]==3) {
				System.out.printf("%4d %-6s %d %4d %4d %4d %5.1f %3c %4d \n", noArray[i], nameArray[i], korArray[i],
						engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
				break;
			}
		}
		/*
		 * 국어점수 80점인 학생들 여러명 찾아서 여러명정보출력
		 */
		System.out.println(">>국어점수 80점인 학생들 여러명 찾아서 여러명정보출력");
		for(int i=0;i<noArray.length;i++) {
			if(korArray[i]==80) {
				System.out.printf("%4d %-6s %d %4d %4d %4d %5.1f %3c %4d \n", noArray[i], nameArray[i], korArray[i],
						engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
				
			}
		}
		/*
		 * 영어점수 50점이하인 학생들 여러명 찾아서 여러명정보출력
		 */
		/*
		 * 수학점수 70점이상인 학생들 여러명 찾아서 여러명정보출력
		 */
		/*
		 * 학점이 D학점이하인 학생모두찾아서 여러명 정보출력
		 */
		
		/*
		 * 정렬
		 *    1.오름차순 
		 *      ex> 1,2,3,4,5....
		 *          a,b,c,d,e....,가 ... 힣
		 *    2.내림차순
		 *    	ex> 5,4,3,2,1
		 *          z,y,x.... , 힣  ... 가
		 */
		
		
	
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> 정렬전  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s %3s %s %s %s %s %3s %s %s%n", "학번", "이름", "국어", "영어", "수학", "총점", "평균", "평점", "석차");
		System.out.printf("-----------------------------------------------\n");
		for (int i = 0; i < noArray.length; i++) {
			System.out.printf("%4d %-6s %d %4d %4d %4d %5.1f %3c %4d \n", noArray[i], nameArray[i], korArray[i],
					engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
		}
		
		/*
		 학생총점순으로 오름차순정렬
		 https://www.youtube.com/watch?v=ebI54DXYQG8
		 */
		int a=10;
		int b=3;
		//swap a,b
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("--swap---");
		int temp = a;
		a = b;
		b= temp;
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		//1회
		for(int j=0;j<noArray.length-1;j++) {
			if(totArray[j] > totArray[j+1]) {
				//swap
				//tot
				int tempTot = totArray[j];
				totArray[j]=totArray[j+1];
				totArray[j+1]=tempTot;
				//no,name,kor,eng,math,avg,grade,rank
			}
		}
		//2회
		//3회
		//4회
		//5회
		//6회
		//7회
		//8회
		//9회
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> 정렬후 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s %3s %s %s %s %s %3s %s %s%n", "학번", "이름", "국어", "영어", "수학", "총점", "평균", "평점", "석차");
		System.out.printf("-----------------------------------------------\n");
		for (int i = 0; i < noArray.length; i++) {
			System.out.printf("%4d %-6s %d %4d %4d %4d %5.1f %3c %4d \n", noArray[i], nameArray[i], korArray[i],
					engArray[i], mathArray[i], totArray[i], avgArray[i], gradeArray[i], rankArray[i]);
		}
		
	}

}
