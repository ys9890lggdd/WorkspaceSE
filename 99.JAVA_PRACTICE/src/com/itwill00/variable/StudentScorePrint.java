package com.itwill00.variable;

public class StudentScorePrint {

	public static void main(String[] args) {
		System.out.println("main start");
		/*
		 * 성적관리에서 학생2명 데이타를 담을 변수선언
		 * 	- 번호, 이름, 국어, 영어, 수학, 총점, 평균, 평점(A(90~100),B(80~89),C(70~79),D(60~69),F(0~59)), 석차
		 */
		int no1;
		String name1;
		int kor1;
		int eng1;
		int math1;
		int tot1;
		double avg1;
		char grade1;
		int rank1;
		
		int no2;
		String name2;
		int kor2;
		int eng2;
		int math2;
		int tot2;
		double avg2;
		char grade2;
		int rank2;
		/*
		 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학) 입력 
		 */
		no1=1;
		name1="강수지";
		kor1=90;
		eng1=88;
		math1=88;
		rank1=0;
		
		no2=2;
		name2="장동건";
		kor2=94;
		eng2=89;
		math2=78;
		rank2=0;
		
		/*
		 * 학생2명의 국어, 영어, 수학점수의 유효성체크
		 *   - 100점이 넘는 수나 음수가 입력되면 메세지를 출력하고 return(프로그램종료)한다.
		 */
		
		
		
		/*
		 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학)를 이용해서
		 * 총점, 평균, 평점, 계산 후 대입 (석차는 0을 대입)
		 */
		tot1=kor1+eng1+math1;
		avg1=tot1/3.0;
		if(avg1>=90) {
			grade1='A';
		}else if(avg1>=80){
			grade1='B';
		}else if(avg1>=70) {
			grade1='C';
		}else if(avg1>=60) {
			grade1='D';
		}else {
			grade1='F';
		}
		
		tot2=kor2+eng2+math2;
		avg2=tot2/3.0;
		if(avg2>=90) {
			grade2='A';
		}else if(avg1>=80){
			grade2='B';
		}else if(avg1>=70) {
			grade2='C';
		}else if(avg1>=60) {
			grade2='D';
		}else {
			grade2='F';
		}
		
		
		/*
		- 출력포맷
 		- 평균은 소수점이하 첫째자리까지출력(반올림)
 		- 석차는 구하지마세요
		--------------학생 성적출력-------------------
		학번  이름   국어 영어 수학 총점 평균 평점 석차
		-----------------------------------------------
		 1   김경호   42   56   78   334  34.8  A   3  
		 2   김경수   45   53   76   334  34.8  A   2  
		-----------------------------------------------
		*/
		System.out.printf("--------------학생 성적출력-------------------%n");
		System.out.printf("%s %3s %3s %s %s %s %s %s %s%n","학번","이름","국어", "영어","수학","총점","평균","평점","석차");
		System.out.printf("-----------------------------------------------%n");
		System.out.printf("%3d %4s %4d %4d %4d %4d %4.1f %3c %4d\n",no1,name1, kor1,eng1,math1,tot1,avg1,grade1,rank1);
		System.out.printf("%3d %4s %4d %4d %4d %4d %4.1f %3c %4d\n",no2,name2, kor2,eng2,math2,tot2,avg2,grade2,rank2);
	}

}
