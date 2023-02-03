
public class SynchronzeUpperThread extends Thread{
	private SynchronizeUpperLowerPrintSharedObject sharedObject;
	public SynchronzeUpperThread(SynchronizeUpperLowerPrintSharedObject sharedObject) {
		this.sharedObject=sharedObject;
	}
	@Override
	public void run() {
		while(true) {
			System.out.print("☆");
			sharedObject.printUpper();
		}
	}
}
