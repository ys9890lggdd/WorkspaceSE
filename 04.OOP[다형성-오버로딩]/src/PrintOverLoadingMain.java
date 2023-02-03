
public class PrintOverLoadingMain {

	public static void main(String[] args) {
		Print p=new Print();
		p.print(1);
		p.print(1,2,3);
		p.print(1,2);
		
		p.print(false);
		p.print(213);
		p.print(3.1);
		p.print("식사하시죠");
		p.print('A');
		p.print(214212);
		
		System.out.print(1);
		System.out.print("수업끝!!");
		System.out.print(45.890);

	}

}
