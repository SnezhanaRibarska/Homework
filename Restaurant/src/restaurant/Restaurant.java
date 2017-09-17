package restaurant;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.lang.Iterable;
import java.security.KeyStore.Entry;
import java.util.Random;
import java.util.Set;

import dish.Dish;
import drink.Drink;
import person.Client;
import person.Waiter;

public class Restaurant {

	private String name;
	private String address;
	private double money;
	private HashSet<Waiter> waiters=new HashSet<>();
	private Menu menu;
	private HashMap<Orderable,Integer> contains;
	protected HashSet<Client> clients=new HashSet<>();
	
	public Waiter getRandomWaiter(){
		Waiter[] servitiori=waiters.toArray(new Waiter[waiters.size()]);
		return servitiori[new Random().nextInt(waiters.size())];
	}
	
	public Restaurant(String name, HashSet<Waiter> waiters) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.waiters = waiters;
		menu=new Menu();
		contains = new HashMap<Orderable,Integer>();
		
		for (Iterator iterator = menu.getDishesh().iterator(); iterator.hasNext();) {
			Dish d = (Dish) iterator.next();
			contains.put(d, 10);
		}
			
		for (Iterator iterator = menu.getDrinks().iterator(); iterator.hasNext();) {
			Drink d = (Drink) iterator.next();
			contains.put(d, 20);
		}
		this.money=1000;
		this.address="Venelin 72";
		
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", address=" + address + ", money=" + money + ", waiters=" + waiters
				+ ", menu=" + menu + ", contains=" + contains + "]";
	}

	public Menu getMenu() {
		return menu;
	}

	public boolean isContain(Orderable item){
		for (Iterator iterator = contains.keySet().iterator(); iterator.hasNext();) {
			Orderable product = (Orderable) iterator.next();
			if(product.equals(item)){
				if(contains.containsValue(0)){
					return false;
				}
			}
			
		}
		return true;
	}

	public Set getClients() {
		return Collections.unmodifiableSet(clients);
	}
	
	public void startWork(HashSet<Client> c){
		for (Client client : c) {
			this.clients.add(client);
			client.setR(this);
		}
	}

	public void setMoney(double d) {
		money=d;
	}

	
}
