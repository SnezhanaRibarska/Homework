package warehouse;

import java.util.Random;

public class Client extends Thread {

	private Shop sh;
	private String productName;

	public Client(Shop sh,String productName) {
		this.sh = sh;
		this.productName = productName;
	}

	@Override
	public void run() {
		while (true) {
			sh.getProduct(productName , 3);
			System.out.println("Client buy 3kg " + productName);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
	}

}
