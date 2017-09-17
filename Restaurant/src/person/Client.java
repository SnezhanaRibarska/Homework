package person;

import java.util.Random;

import restaurant.Orderable;
import restaurant.Restaurant;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Client {

	private String name;
	protected double money;
	protected Restaurant r;
	protected double smetka=0;
	protected Waiter w=null;
	

	public Client(String name, double money) {
		this.name = name;
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", money=" + money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public abstract void makeOrder();
	public double wantBill() {
		return smetka;
	}
	public void payBill(){
		int chance=new Random().nextInt(100);
		double bakchish=0;
		int temp=0;
		//ostavq bakchish
		if(chance>20){
			 temp=(new Random().nextInt(5)+5);
			 bakchish=(temp/100)*smetka;
			 w.setMoney(temp);
			 r.setMoney(smetka-temp);
		}
		else{
			r.setMoney(smetka);
		}
	}

	public void setR(Restaurant restaurant) {
		this.r=restaurant;
	}

	
	
}

