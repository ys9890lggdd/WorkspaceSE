
public class OuterComposingInnerClass {
	/******* member field***********/
	public int outer_member_field;
	/******* member method**********/
	public void outer_member_method() {
		System.out.println("OuterComposingInnerClass.outer_member_method()");
	}
	/************Outer클래스에서 Inner클래스 사용*********/
	public void outer_inner_class_use() {
		/*
		 * local변수
		 */
		int local_variable=100;
		/********************member inner class[CASE1]************************
		ParentFirstConcreteClass childFirstConcreateClass=new ChildFirstConcreateClass();
		childFirstConcreateClass.local_inner_outer_access();
		*****************************************************************/
		/*
		 << 특정클래스의 메쏘드를 재정의해야할때 >>
		   1. local위치   에서 이름이존재하지 않는 클래스를정의
		   2. local위치(?)에서 객체를 생성 
		 */
		/********************annonymous local inner class[CASE2]*********************/
		ParentFirstConcreteClass childConcreteClass=new ParentFirstConcreteClass() {
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentFirstConcreteClass를 상속받는 "
						+ "이름없는로칼 내부클래스에서 재정의한 local_inner_outer_access()");
			}
			
		};
		childConcreteClass.local_inner_outer_access();
		
		
		ParentSecondAbstractClass childAbstractClass = 
				new ParentSecondAbstractClass() {
					@Override
					public void local_inner_outer_access() {
						System.out.println("ParentSecondAbstractClass를 상속받는 "
								+ "이름없는 클래스에서 재정의한 local_inner_outer_access()");
					}
				};
		childAbstractClass.local_inner_outer_access();
		
		ParentThirdInterface childThirdInterface = 
				new ParentThirdInterface() {
			
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentThirdInterface를 상속받은(구현한) "
						+ "이름없는 클래스에서 재정의한 local_inner_outer_access() ");
				
			}
		};
		childThirdInterface.local_inner_outer_access();
		
		
		Object oc=new Object() {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "난 재정의된 toString";
			}
		};
		System.out.println(oc);
		
		
		
	}// end method
	
	/*********************************************
	 ParentFirstConcreteClass를 상속받고 local_inner_outer_access() 메쏘드를 재정의하는 Inner클래스 
	*/
	/************************* member inner class[CASE1] *******************************************
	public class ChildFirstConcreateClass extends ParentFirstConcreteClass{
					@Override
					public void local_inner_outer_access() {
						System.out.println("ParentFirstConcreteClass를 상속받는 "
								+ "ChildFirstConcreateClass에서 재정의한 local_inner_outer_access()");
					}
	}
	*/
	public static void main(String[] args) {
		OuterComposingInnerClass outerComposingInnerClass=new OuterComposingInnerClass();
		outerComposingInnerClass.outer_inner_class_use();
	}
	
}
