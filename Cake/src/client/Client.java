package client;

import other.Order;
import other.SweetShop;

public abstract class Client {

	private String name;
	private String gsm;
	private int money;
	protected SweetShop shop;
	private Order order;
	protected String address;
	
	public Client(String name, String gsm,int money) {
		this.name = name;
		this.gsm = gsm;
		this.address = "my address";
	}
	
	public void addShop(SweetShop c){
		this.shop=c;
	}
	abstract public void makeOrder();
}
