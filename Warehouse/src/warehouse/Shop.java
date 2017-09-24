package warehouse;

import java.util.HashMap;
import java.util.Random;

import warehouse.Warehouse.Type;

public class Shop extends Thread {

	private Warehouse wh;

	private enum Type {
		FRUITS, VEGETABLES, MEATS
	};
	
	private static final int MIN_QUANTITY = 5;
	private HashMap<Type, HashMap<String, Integer>> catalog;

	public Shop(Warehouse wh) {
		this.wh = wh;
		catalog = new HashMap<>();
		catalog.put(Type.VEGETABLES, new HashMap<>());
		catalog.put(Type.FRUITS, new HashMap<>());
		catalog.put(Type.MEATS, new HashMap<>());
		catalog.get(Type.VEGETABLES).put("Potato", 15);
		catalog.get(Type.VEGETABLES).put("Eggplant", 15);
		catalog.get(Type.VEGETABLES).put("Cucumber", 15);
		catalog.get(Type.FRUITS).put("Banan", 15);
		catalog.get(Type.FRUITS).put("Orange", 15);
		catalog.get(Type.FRUITS).put("Apple", 15);
		catalog.get(Type.MEATS).put("Pork", 15);
		catalog.get(Type.FRUITS).put("Beef", 15);
		catalog.get(Type.FRUITS).put("Chicken", 15);
	}

	@Override
	public void run() {
		while (true) {
			this.deliver();
		}
	}

	public synchronized void deliver() {
		while (!hasInsufficient()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		fillQuanities();
		notifyAll();
	}

	public synchronized void getProduct(String name, int quantity) {
		while (insufficient(name, quantity)) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		removeQuantity(name, quantity);
		notifyAll();
	}

	private void removeQuantity(String name, int quantity) {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name)) {
					products.put(s, products.get(s) - quantity);
				}
			}
		}
	}

	private boolean insufficient(String name, int quantity) {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name)) {
					if (products.get(s) < quantity) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void fillQuanities() {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (products.get(s) < MIN_QUANTITY) {
					System.out.println(s + "not enough! Fill from storage!");
					wh.getProduct(s);
					products.put(s, products.get(s) + 5);
				}
			}
		}
	}

	private boolean hasInsufficient() {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (products.get(s) < MIN_QUANTITY) {
					return true;
				}
			}
		}
		return false;
	}


}
