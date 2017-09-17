package imot;

import java.util.Random;

import agency.Agent;
import client.Seller;

public class Imot {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		Imot other = (Imot) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		return true;
	}

	public interface IImotType{};
	protected enum ConstructionType{EPK,TUHLA,PANEL,KIRPICH};
	public enum Kind{APARTAMENT,HOUSE,PARCEL};
	
	private String description;
	private String address;
	private double price;
	private double area;
	private Agent a;
	private Seller s;
	private IImotType type;
	protected Kind kind;
	
	public Imot(String description, String address, double price, double area) {
		this.description = description;
		this.address = address;
		this.price = price;
		this.area = area;
	}
	
	public static ConstructionType getRandomConstructionType(){
		int chance=new Random().nextInt(ConstructionType.values().length);
		switch(chance){
		case 0:
			return ConstructionType.EPK;
		case 1:
			return ConstructionType.KIRPICH;
		case 2:
			return ConstructionType.PANEL;
		case 3:
			return ConstructionType.TUHLA;
		}
		return null;
	}
	
	public void setAgent(Agent a){
		this.a=a;
	}

	public double getMoney() {
		return price;
	}

	public Agent getAgent() {
		return a;
	}
	
}
