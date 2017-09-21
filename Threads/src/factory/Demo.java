package factory;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo {

	public static void main(String[] args) {

		ArrayList<Runnable> tasks = new ArrayList<>();
		tasks.add(new Frame());
		tasks.add(new Engine());
		tasks.add(new Seat());
		tasks.add(new Seat());
		tasks.add(new Seat());
		tasks.add(new Seat());
		tasks.add(new Seat());
		tasks.add(new Tire());
		tasks.add(new Tire());
		tasks.add(new Tire());
		tasks.add(new Tire());

		ArrayList<Future> futures = new ArrayList<>();
		System.out.println("start!");
		long start=System.currentTimeMillis();
		
		ExecutorService projectManager = Executors.newFixedThreadPool(3);

		for (Runnable r : tasks) {
			futures.add(projectManager.submit(r));
		}

		while (true) {
			int tasksDone = 0;
			for (Future f : futures) {
				tasksDone = f.isDone() ? tasksDone + 1 : tasksDone;
			}
			if (tasksDone == futures.size()) {
				break;
			}
		
		}
		projectManager.shutdown();
		System.out.println("end for " + (System.currentTimeMillis()-start));
	}

}
