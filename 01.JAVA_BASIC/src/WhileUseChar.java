
public class WhileUseChar {

	public static void main(String[] args) {
		/*
		 * 문자출력
		 */
		char c1=0;
		while(c1< 65535) {
			System.out.print(c1+" ");
			c1++;
			if(c1%100==0) {
				System.out.println();
			}
		}
		System.out.println();
		/*
		 * - 영문소문자출력
		 *  a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,
		 */
		char c2='a';
		while(c2<='z') {
			System.out.print(c2);
			System.out.print(",");
			c2++;
		}
		System.out.println();
		/*
		 - 영문소문자출력
		   a,b,c,d,e,
		   f,g,h,i,j,
		   k,l,m,n,o,
		   p,q,r,s,t,
		   u,v,w,x,y,
		   z,
		 */
		
		char c3='a';
		int letterCount=0;
		while(c3<='z') {
			System.out.print(c3+" ");
			letterCount++;
			if(letterCount%5==0) {
				System.out.print("\n");
			}
			c3++;
			
		}
		System.out.println();
		char c4='A';
		while(c4<='Z') {
			System.out.print(c4+" ");
			if((c4-'A'+1)%5==0) {
				System.out.print("\n");
			}
			c4++;
		}
		System.out.println();
		
		/*
		 * Quiz:
			- 한글출력
		    - 숫자형문자(0~9)출력
		 */
		char han='가';
		while(han<='힣') {
			System.out.print(han);
			if((han-'가'+1)%20==0) {
				 System.out.print("\n");
			}
			han++;
		}
		
	}

}
