package warehouse;

import java.util.HashMap;

public class Warehouse {

	public enum Type{FRUITS, VEGETABLES, MEATS};
	
	private static final int MIN_QUANTITY = 5;
	private HashMap<Type,HashMap<String,Integer>> catalog;
	
	public Warehouse(){
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
	
	public synchronized void deliver(){
		//check for insufficient products
		//add 25 quantity for each that is below min
		//wait if none is insufficient
		//notify when added any quantity
		while(!hasInsufficient()){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		fillQuanities();
		notifyAll();
	}
	
	private void fillQuanities() {
		for (HashMap<String,Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if(products.get(s) < MIN_QUANTITY){
					products.put(s, products.get(s)+25);
					System.out.println(s + " not sufficient in warehouse! ");
				}
			}
		}
	}

	private boolean hasInsufficient() {
		for (HashMap<String,Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if(products.get(s) < MIN_QUANTITY){
					return true;
				}
			}
		}
		return false;
	}

	public synchronized void getProduct(String name) {
		//search for this product
		//if insufficient - wait
		//if can take - decrement quantity by 5 and notify
		while(insufficient(name)){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		removeQuantity(name);
		notifyAll();
	}

	private void removeQuantity(String name) {
		for(HashMap<String,Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(s.equals(name)){
					products.put(s,products.get(s) - 5);
				}
			}
		}
	}

	private boolean insufficient(String name) {
		for(HashMap<String,Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(s.equals(name)){
					if(products.get(s) < MIN_QUANTITY){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	

}

