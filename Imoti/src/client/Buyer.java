package client;

import java.util.HashSet;
import java.util.Random;

import agency.Agency;
import agency.Agent;
import agency.Ogled;
import imot.Imot;

public class Buyer extends Client {

	public Buyer(String name, String gsm , double money) {
		super(name, gsm);
		this.money=money;
		ogledi=new HashSet<>();
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
		Buyer other = (Buyer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private HashSet<Ogled> ogledi;
	private int id;
	private int unique=1;
	
	public Imot getRandomImot() {
		Ogled view = (Ogled) ogledi.toArray()[new Random().nextInt(ogledi.toArray().length)];
		return view.getImot();
	}
	
	public void searchImot(Agency agency){
		this.a=agency.getRandomAgent();
		this.a.addBuyers(this);
	}
	
	public void viewImot(Imot i){
		if(i.getMoney()<money){
			//Imot i, Agent a, String date, Buyer buyer
			Ogled o=new Ogled(i,getAgent(),"03.09.2017",this);
			this.ogledi.add(o);
			this.a.addOgled(o);
			
		}
	}
	
	public void buyImot(Imot i,Agency agency){
		for (Ogled ogled : ogledi) {
			if(ogled.getImot().equals(i)){
				 Seller seller = this.a.getSeller(i);
				 this.payCommision(i, agency);
				 seller.payCommision(i, agency);
			}
		}
	}
}
