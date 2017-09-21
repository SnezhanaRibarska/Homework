package factory;

public abstract class CarPart implements Runnable{

	private String name;
	private int duration;
	
	
	public CarPart(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(duration*1000);
		} catch (InterruptedException e) {
			System.out.println("ops");
		}
		System.out.println(Thread.currentThread().getName() + " says - " + name + " is ready.");
	}
	
}
