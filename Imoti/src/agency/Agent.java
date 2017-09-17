package agency;

import java.util.ArrayList;
import java.util.HashSet;

import client.Buyer;
import client.Seller;
import imot.Imot;

public class Agent {

	private String name;
	private String gsm;
	private double money;
	private int id;
	private static int unique=1;
	private HashSet<Seller> sellers;
	private HashSet<Buyer> buyers;
	private ArrayList<Ogled> ogledi;
	
	public Agent(String name,String gsm) {
		this.name = name;
		this.gsm=gsm;
		this.buyers = new HashSet<>();
		this.sellers = new HashSet<>();
		this.ogledi = new ArrayList<>();
		this.id=unique++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void addSeller(Seller seller) {
		sellers.add(seller);
	}
	
	public void addBuyers(Buyer buyer){
		buyers.add(buyer);
	}

	public void addOgled(Ogled o) {
		ogledi.add(o);
	}
	
	public double getMoney(){
		return money;
	}
	

	public void setMoney(double money){
		this.money=money;
	}

	public Seller getSeller(Imot i){
		for (Seller seller : sellers) {
			if(seller.getImot().equals(i)){
				return seller;
			}
		}
		return null;
	}
	
	
}
