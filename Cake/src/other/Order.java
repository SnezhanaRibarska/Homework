package other;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cake.Cake;
import client.Client;

public class Order {

	private Client client;
	private int price;
	private String address;
	private ArrayList<Cake> cakes;
	private String date;
	private String hour;
	
	public Order(Client client, int price, String address, ArrayList<Cake> cakes, String date, String hour) {
		this.client = client;
		this.price = price;
		this.address = address;
		this.cakes = cakes;
		this.date = date;
		this.hour = hour;
	}
	
	 public List<Cake> getCakes() {
			return Collections.unmodifiableList(this.cakes);
		}
	
}
