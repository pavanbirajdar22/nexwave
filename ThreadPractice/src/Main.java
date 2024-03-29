
class Widget {
	public synchronized void doSomething() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class LoggingWidget extends Widget {
	public synchronized void doSomething() {
		System.out.println(Thread.currentThread().getName() + ": calling doSomething");
		super.doSomething();
	}
}

public class Main {

	public static void main(String[] args) {
		//Widget w = new Widget();
		LoggingWidget l1 = new LoggingWidget();
		
		Thread t1 = new Thread(() -> {
			l1.doSomething();
		});
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread t2 = new Thread(() -> {
			l1.doSomething();
		});
		t2.start();
	}

}
