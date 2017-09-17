package client;

import agency.Agency;
import imot.Imot;

public class Seller extends Client {

	private Imot i; 
	private int id;
	private static int unique=1;
	
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
		Seller other = (Seller) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Seller(String name, String gsm,Imot i) {
		super(name, gsm);
		this.i=i;
		this.id=unique++;
	}

	public void registrateImot(Agency agency){
		agency.addImot(this.i);
		this.a=agency.getRandomAgent();
		this.a.addSeller(this);
		this.i.setAgent(a);
	}
	
	public Imot getImot(){
		return i;
	}
	
}
