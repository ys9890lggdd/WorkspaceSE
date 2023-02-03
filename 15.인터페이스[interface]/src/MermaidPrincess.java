
public class MermaidPrincess 
		implements Mermaid,Princess {

	@Override
	public void speak() {
		System.out.println("Princess.speak() 의구현[재정의]");
	}

	@Override
	public void think() {
		System.out.println("Princess.think() 의구현[재정의]");
	}

	@Override
	public void fastSwim() {
		System.out.println("Mermaid.fastSwim() 의구현[재정의]");	
	}

	@Override
	public void liveSea() {
		System.out.println("Mermaid.liveSea() 의구현[재정의]");	
	}
	
}
