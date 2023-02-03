
public class SynchronzeLowerThread extends Thread {
	private SynchronizeUpperLowerPrintSharedObject sharedObject;
	public SynchronzeLowerThread(SynchronizeUpperLowerPrintSharedObject sharedObject) {
		this.sharedObject=sharedObject;
	}
	@Override
	public void run() {
		while(true) {
			System.out.print("★");
			sharedObject.printLower();
		}
	}
}
